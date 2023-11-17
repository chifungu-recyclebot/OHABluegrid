package ui.citizen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import data.model.ReportedIssue
import com.greenway.ohabluegrid.databinding.ItemIssueBinding
import kotlin.collections.emptyList



class CitizenIssueListAdapter : RecyclerView.Adapter<CitizenIssueListAdapter.ViewHolder>() {

    private var issueList: List<ReportedIssue> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemIssueBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val issue = issueList[position]
        holder.bind(issue)
    }

    override fun getItemCount(): Int {
        return issueList.size
    }

    fun setIssues(issues: List<ReportedIssue>) {
        issueList = issues
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemIssueBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(issue: ReportedIssue) {
            binding.issue = issue
            binding.executePendingBindings()
        }
    }
}
