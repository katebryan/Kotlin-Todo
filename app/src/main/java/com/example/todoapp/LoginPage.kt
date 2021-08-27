package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.amplifyframework.AmplifyException
import com.amplifyframework.auth.AuthUserAttributeKey
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin
import com.amplifyframework.auth.options.AuthSignUpOptions
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

//        Amplify.Auth.confirmSignUp(
//            "username", "0000",
//            { result ->
//                if (result.isSignUpComplete) {
//                    Log.i("AuthQuickstart", "Confirm signUp succeeded")
//                } else {
//                    Log.i("AuthQuickstart","Confirm sign up not complete")
//                }
//            },
//            { Log.e("AuthQuickstart", "Failed to confirm sign up", it) }
//        )

        // get reference to all views
        val etEmail = findViewById<EditText>(R.id.et_email)
        val etUsername = findViewById<EditText>(R.id.et_username)
        val etPassword = findViewById<EditText>(R.id.et_password)
        val btnSubmit = findViewById<Button>(R.id.btn_submit)

        // set on-click listener
        btnSubmit.setOnClickListener {
            val email = etEmail.text
            val username = etUsername.text
            val password = etPassword.text

            val errorText = "Please enter a valid Username"

            println(password)

            if (email.length > 5) {
                Toast.makeText(this@LoginPage, email, Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                val options = AuthSignUpOptions.builder()
                    .userAttribute(AuthUserAttributeKey.email(), email.toString())
                    .build()
                Amplify.Auth.signUp(username.toString(), password.toString(), options,
                    { Log.i("AuthQuickStart", "Sign up succeeded: $it") },
                    { Log.e ("AuthQuickStart", "Sign up failed", it) }
                )

            } else {
                Toast.makeText(this@LoginPage, errorText, Toast.LENGTH_LONG).show()

            }
        }
    }
}