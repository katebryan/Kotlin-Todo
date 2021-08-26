package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class LoginPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)

        // get reference to all views
        val etUsername = findViewById<EditText>(R.id.et_user_name)
        val etPassword = findViewById<EditText>(R.id.et_password)
        val btnSubmit = findViewById<Button>(R.id.btn_submit)

        // set on-click listener
        btnSubmit.setOnClickListener {
            val username = etUsername.text
            val password = etPassword.text

            val errorText = "Please enter a valid Username"

            println(password)

            if (username.length > 5) {
                Toast.makeText(this@LoginPage, username, Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this@LoginPage, errorText, Toast.LENGTH_LONG).show()

            }
        }
    }
}