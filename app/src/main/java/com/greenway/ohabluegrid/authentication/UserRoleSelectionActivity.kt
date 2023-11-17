package com.greenway.ohabluegrid.authentication


import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.greenway.ohabluegrid.R
import dashboard.admin.AdminDashboardActivity
import dashboard.citizen.CitizenDashboardActivity
import dashboard.waste_manager.WasteManagerDashboardActivity

class UserRoleSelectionActivity : AppCompatActivity() {

    private val firebaseAuth = FirebaseAuth.getInstance()

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_role_selection)

        val email = intent.getStringExtra("email") ?: ""
        val password = intent.getStringExtra("password") ?: ""

        // Your existing logic for user role selection can remain unchanged
        val role = getUserRole()

        // Directly navigate to the dashboard for simplicity
        navigateToDashboard(role)
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    private fun navigateToDashboard(role: String) {
        when (role) {
            CITIZEN_ROLE ->
                startActivity(Intent(this, CitizenDashboardActivity::class.java))
            WASTE_MANAGER_ROLE ->
                startActivity(Intent(this, WasteManagerDashboardActivity::class.java))
            ADMIN_ROLE ->
                startActivity(Intent(this, AdminDashboardActivity::class.java))
            else -> {
                // Handle unknown role
            }
        }
        finishAffinity() // Finish all previous activities
    }

    private fun getUserRole(): String {
        // Implement your logic to determine the user role based on Firebase Authentication
        // For example, you can use the user's email, database, or custom claims
        // Replace the following line with your actual logic
        val currentUser = firebaseAuth.currentUser
        return when {
            currentUser != null && currentUser.email == "your@example.com" -> CITIZEN_ROLE
            currentUser != null && currentUser.email == "waste@example.com" -> WASTE_MANAGER_ROLE
            currentUser != null && currentUser.email == "admin@example.com" -> ADMIN_ROLE
            else -> "Unknown"
        }
    }

    companion object {
        const val CITIZEN_ROLE = "Citizen"
        const val WASTE_MANAGER_ROLE = "WasteManager"
        const val ADMIN_ROLE = "Admin"
    }
}
