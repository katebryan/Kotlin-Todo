package com.example.todoapp

import org.junit.Test

import org.junit.Assert.*

open class TodoList {
    private var arrayList: MutableList<Todo> = mutableListOf<Todo>()

    fun addItemToList(todoItem: String) {
        arrayList.add(Todo(todoItem, false))
    }

    fun getTodoList(): List<Todo> {
        return arrayList
    }
}

class ExampleUnitTest {
    @Test
    fun emptyListIsEmpty() {
        val list = TodoList()
        val result = list.getTodoList()
        assertEquals(0, result.size)
    }

    @Test
    fun onAddItem_listHasOneItem() {
        val list = TodoList()
        list.addItemToList("dave")
        val result = list.getTodoList()
        assertEquals(1, result.size)
    }

}