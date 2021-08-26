package com.example.todoapp

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
            Toast.makeText(this@LoginPage, username, Toast.LENGTH_LONG).show()
            println(password)

            // your code to validate the user_name and password combination
            // and verify the same

        }
    }
}