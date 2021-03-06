package com.example.todoapp

import android.graphics.Paint.STRIKE_THRU_TEXT_FLAG
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
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

    fun addToDo(todo: Todo) {
        todos.add(todo)
        // notify the adapter that a change has been made
        notifyItemInserted(todos.size -1)
    }

    fun deleteTodo() {
        todos.removeAll { todo ->
            todo.isChecked
        }
        // this updates the whole list
        notifyDataSetChanged()
    }

    // toggle checked view state
    private fun toggleStrikeThrough(tvTodoTitle: TextView, isChecked: Boolean) {
        if (isChecked) {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags or STRIKE_THRU_TEXT_FLAG
        } else {
            tvTodoTitle.paintFlags = tvTodoTitle.paintFlags and STRIKE_THRU_TEXT_FLAG.inv()
        }
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        // called when a new todo item is visible
        // defines which text you want to text to this view
        val currentTodo = todos[position]

        holder.itemView.apply {
            tvTodoTitle.text = currentTodo.title
            cbDone.isChecked = currentTodo.isChecked
            toggleStrikeThrough(tvTodoTitle, currentTodo.isChecked)
            cbDone.setOnCheckedChangeListener { _, isChecked ->
                toggleStrikeThrough(tvTodoTitle, isChecked)
                currentTodo.isChecked = !currentTodo.isChecked
            }
        }
    }

    override fun getItemCount(): Int {
        // returns the amount of items we have in the todo list
        return todos.size
    }
}