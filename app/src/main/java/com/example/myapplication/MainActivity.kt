package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = FirebaseAuth.getInstance()

        val buttonNavigate = findViewById<Button>(R.id.Login)
        val buttonNavig = findViewById<Button>(R.id.Register)

        buttonNavigate.setOnClickListener {
            // Assuming you have some logic to log in the user with Firebase
            // For example: auth.signInWithEmailAndPassword(email, password)

            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        buttonNavig.setOnClickListener {
            val intent = Intent(this, MainActivity4::class.java)
            startActivity(intent)
        }

        // Check if the user is already authenticated, and if so, navigate to MainActivity3
        if (auth.currentUser != null) {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
            finish()  // Optional: Close the current activity to prevent going back
        }
    }
}
