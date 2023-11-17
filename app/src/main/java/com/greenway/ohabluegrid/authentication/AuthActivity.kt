
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.greenway.ohabluegrid.R
import com.greenway.ohabluegrid.authentication.UserRoleSelectionActivity
import dashboard.admin.AdminDashboardActivity
import dashboard.citizen.CitizenDashboardActivity
import dashboard.waste_manager.WasteManagerDashboardActivity

class AuthActivity : AppCompatActivity() {

    private val firebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        // Check if the user is already signed in
        if (firebaseAuth.currentUser != null) {
            navigateToDashboard()
        }

        // Set click listeners for sign in and sign up buttons
        findViewById<Button>(R.id.signInButton).setOnClickListener {
            startActivity(Intent(this, SignInActivity::class.java))
        }

        findViewById<Button>(R.id.signUpButton).setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
        }
    }

    private fun navigateToDashboard() {
        val userRole = getUserRole()
        val dashboardActivity = when (userRole) {
            UserRoleSelectionActivity.CITIZEN_ROLE -> CitizenDashboardActivity::class.java
            UserRoleSelectionActivity.WASTE_MANAGER_ROLE -> WasteManagerDashboardActivity::class.java
            UserRoleSelectionActivity.ADMIN_ROLE -> AdminDashboardActivity::class.java
            else -> null
        }

        dashboardActivity?.let {
            startActivity(Intent(this, it))
            finish()
        }
    }

    private fun getUserRole(): String {
        // Implementation will depend on how user roles are stored and retrieved
        // from the backend or local storage
        return "Unknown"
    }
}
