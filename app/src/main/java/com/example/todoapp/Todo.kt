package com.example.todoapp

// it has a class type of 'data' because all this is for is holding data
data class Todo (
    val title: String,
    val isChecked: Boolean = false
)