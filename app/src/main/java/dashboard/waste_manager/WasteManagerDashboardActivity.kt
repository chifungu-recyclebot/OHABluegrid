package dashboard.waste_manager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import com.greenway.ohabluegrid.R
import com.greenway.ohabluegrid.databinding.ActivityWasteManagerReportBinding
import data.model.ReportedIssue
import ui.waste_manager.WasteManagerAdapter
import java.util.Collections.emptyList

class WasteManagerDashboardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWasteManagerReportBinding
    private lateinit var wasteManagerAdapter: WasteManagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWasteManagerReportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize the RecyclerView and its adapter
        wasteManagerAdapter = WasteManagerAdapter()

        // Set up the RecyclerView
        binding.wasteManagerRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.wasteManagerRecyclerView.adapter = wasteManagerAdapter

        // Example: Fetch a list of reported issues and set it to the adapter
        val reportedIssues = getReportedIssuesFromRepository()
        wasteManagerAdapter.setIssues(reportedIssues)

        // Implement any additional setup logic as needed
    }

    fun replaceFragment(fragment: Fragment) {
        val fragmentManager: FragmentManager = supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }


    private fun getReportedIssuesFromRepository(): List<ReportedIssue> {
        // Fetch the list of reported issues from your repository or data source
        // For example, you can use the IssueRepository.getAllReportedIssues() method
        // return issueRepository.getAllReportedIssues()

        // Placeholder return, replace it with your actual data retrieval logic
        return emptyList()
    }
}
