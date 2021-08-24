package com.example.todoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        // this is the lifecycle hook that's called on component render
        super.onCreate(savedInstanceState)

        // this is where the styling is pulled in - activity_main is the equivalent of a .css file
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}