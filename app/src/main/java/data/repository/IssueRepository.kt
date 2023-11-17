package data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import data.model.IssueStatus
import data.model.ReportedIssue
import data.model.User

class IssueRepository {

    private val issueList: MutableList<ReportedIssue> = mutableListOf()

    private val _reportedIssuesLiveData: MutableLiveData<List<ReportedIssue>> = MutableLiveData()
    val reportedIssuesLiveData: LiveData<List<ReportedIssue>> get() = _reportedIssuesLiveData

    @Synchronized
    fun addReportedIssue(reportedIssue: ReportedIssue) {
        issueList.add(reportedIssue)
        _reportedIssuesLiveData.value = issueList.toList()
    }

    @Synchronized
    fun getIssueById(issueId: String): ReportedIssue? {
        return issueList.find { it.uniqueId == issueId }
    }

    @Synchronized
    fun getAssignedIssuesForWasteManager(wasteManager: User): List<ReportedIssue> {
        return issueList.filter { it.assignedWasteManager?.userId == wasteManager.userId }
    }

    @Synchronized
    fun getAllReportedIssues(): List<ReportedIssue> {
        return issueList.toList()
    }

    @Synchronized
    fun updateIssueStatus(issueId: String, newStatus: IssueStatus) {
        val updatedList = issueList.map {
            if (it.uniqueId == issueId) {
                it.copy(status = newStatus)
            } else {
                it
            }
        }
        issueList.clear()
        issueList.addAll(updatedList)
        _reportedIssuesLiveData.value = issueList.toList()
    }

    // Additional methods for issue management can be added here
}
