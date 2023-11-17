package ui.admin

import androidx.recyclerview.widget.RecyclerView
import com.greenway.ohabluegrid.databinding.ItemAdminIssueBinding
import data.model.IssueStatus
import data.model.ReportedIssue

class ViewHolder(private val binding: ItemAdminIssueBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(issue: ReportedIssue) {
        // Implement logic to bind data to the view elements
        // For example:
        val issueType: String = issue.issueType // Assuming you have an 'issueType' property in ReportedIssue
        val status: IssueStatus = issue.status // Assuming you have a 'status' property in ReportedIssue

        binding.issueTitle.text = issueType
        binding.issueDescription.text = status.toString()
        // Add more bindings based on your data model
    }
}
