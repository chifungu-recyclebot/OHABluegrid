package dashboard.admin// dashboard.admin.AdminDashboardActivity.kt


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.greenway.ohabluegrid.R
import ui.admin.AdminTableFragment
import ui.citizen.CitizenIssueListAdapter

class AdminDashboardActivity : AppCompatActivity() {

    private lateinit var issueListAdapter: CitizenIssueListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_dashboard)

        // Initialize the RecyclerView and its adapter
        issueListAdapter = CitizenIssueListAdapter()



        // Set up the RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewAdmin)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = issueListAdapter

        // Add the initial fragment
        supportFragmentManager.commit {
            replace(R.id.fragmentContainer, AdminTableFragment.newInstance())
        }
    }


}
