package com.example.todoapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_todo.view.*
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(
    // the variable declared here can only be accessed inside the Todo class
    private val todos: MutableList<Todo>
): RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {
    // this holds the layout of a specific item (view is what it looks like)
    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        // how should a specific item look?
        return TodoViewHolder(
            // use the layoutInflator to get a reference to the specific view you would like
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_todo,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        // called when a new todo item is visible
        // defines which text you want to text to this view
        val currentTodo = todos[position]

        holder.itemView.apply {
            tvTodoTitle
            cbDone
        }
        currentTodo.isChecked
    }

    override fun getItemCount(): Int {
        // returns the amount of items we have in the todo list
        return todos.size
    }
}