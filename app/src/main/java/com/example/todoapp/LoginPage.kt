package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.amplifyframework.AmplifyException
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin
import com.amplifyframework.core.Amplify


class LoginPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)

        // setting up Amplify
        try {
            Amplify.addPlugin(AWSCognitoAuthPlugin())
            Amplify.configure(applicationContext)
            Amplify.Auth.fetchAuthSession(
                { Log.i("AmplifyQuickstart", "Auth session = $it") },
                { Log.e("AmplifyQuickstart", "Failed to fetch auth session", error("Amplify failed to fetch auth sesh")) }
            )
        } catch (error: AmplifyException) {
            Log.e("MyAmplifyApp", "Could not initialize Amplify", error)
        }

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
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this@LoginPage, errorText, Toast.LENGTH_LONG).show()

            }
        }
    }
}