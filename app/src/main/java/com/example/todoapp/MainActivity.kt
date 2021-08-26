package com.example.todoapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // promise to Kotlin that this variable will be initialised later
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        // this is the lifecycle hook that's called on component render
        super.onCreate(savedInstanceState)

        // this is where the styling is pulled in - activity_main is the equivalent of a .css file
        setContentView(R.layout.activity_main)
        todoAdapter = TodoAdapter(mutableListOf())

        rvTodoItems.adapter = todoAdapter
        rvTodoItems.layoutManager = LinearLayoutManager(this)

        btnAddTodo.setOnClickListener {
            val todoTitle = etTodoItem.text.toString()
            if (todoTitle.isNotEmpty()) {
                val todo = Todo(todoTitle)
                todoAdapter.addToDo(todo)
                etTodoItem.text.clear()
            }
        }

        btnDeleteTodo.setOnClickListener {
            todoAdapter.deleteTodo()
        }
    }

}

