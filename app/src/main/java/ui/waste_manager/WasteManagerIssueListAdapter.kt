package ui.waste_manager

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.greenway.ohabluegrid.R
import data.model.ReportedIssue
import java.util.Collections.emptyList

class WasteManagerAdapter : RecyclerView.Adapter<WasteManagerAdapter.ViewHolder>() {

    private var issueList: List<ReportedIssue> = emptyList() // Replace with your actual data model

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_issue, parent, false)
        return ViewHolder(itemView)
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

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(issue: ReportedIssue) {
            // Implement logic to bind data to the view elements
            // For example:
            // val titleTextView = itemView.findViewById<TextView>(R.id.issueTitle)
            // titleTextView.text = issue.title
            // val descriptionTextView = itemView.findViewById<TextView>(R.id.issueDescription)
            // descriptionTextView.text = issue.description
            // Add more bindings based on your data model
        }
    }
}
