import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.greenway.ohabluegrid.R
import com.greenway.ohabluegrid.authentication.UserRoleSelectionActivity

class SignUpActivity : AppCompatActivity() {

    private val firebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        findViewById<Button>(R.id.signUpButton).setOnClickListener {
            val email = findViewById<EditText>(R.id.emailEditText).text.toString()
            val password = findViewById<EditText>(R.id.passwordEditText).text.toString()

            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    runOnUiThread {
                        if (task.isSuccessful) {
                            navigateToUserRoleSelection(email, password)
                        } else {
                            // Handle unsuccessful sign-up
                        }
                    }
                }
        }
    }

    private fun navigateToUserRoleSelection(email: String, password: String) {
        val intent = Intent(this, UserRoleSelectionActivity::class.java).apply {
            putExtra("email", email)
            putExtra("password", password)
        }
        startActivity(intent)
        finish()
    }
}
