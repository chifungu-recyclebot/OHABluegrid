package com.greenway.ohabluegrid.authentication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.greenway.ohabluegrid.R
import com.greenway.ohabluegrid.authentication.UserRoleSelectionActivity
import dashboard.admin.AdminDashboardActivity
import dashboard.citizen.CitizenDashboardActivity
import dashboard.waste_manager.WasteManagerDashboardActivity

class SignInActivity : AppCompatActivity() {

    private val firebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in) // Set the layout without data binding

        findViewById<Button>(R.id.signInButton).setOnClickListener {
            val email = findViewById<EditText>(R.id.emailEditText).text.toString()
            val password = findViewById<EditText>(R.id.passwordEditText).text.toString()

            firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    runOnUiThread {
                        if (task.isSuccessful) {
                            navigateToDashboard()
                        } else {
                            // Handle unsuccessful sign-in
                        }
                    }
                }
        }
    }

    private fun navigateToDashboard() {
        val userRole = getUserRole()
        when (userRole) {
            UserRoleSelectionActivity.CITIZEN_ROLE ->
                startActivity(Intent(this, CitizenDashboardActivity::class.java))
            UserRoleSelectionActivity.WASTE_MANAGER_ROLE ->
                startActivity(Intent(this, WasteManagerDashboardActivity::class.java))
            UserRoleSelectionActivity.ADMIN_ROLE ->
                startActivity(Intent(this, AdminDashboardActivity::class.java))
            else -> {
                // Handle unknown user role
            }
        }
        finish()
    }

    private fun getUserRole(): String {
        // Implementation will depend on how user roles are stored and retrieved
        // from the backend or local storage
        return "Unknown"
    }
}
