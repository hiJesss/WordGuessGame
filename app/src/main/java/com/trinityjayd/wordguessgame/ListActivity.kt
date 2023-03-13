package com.trinityjayd.wordguessgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListActivity : AppCompatActivity() {

    private val itemsList = ArrayList<String>()
    private lateinit var customAdapter: CustomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        title = "RecyclerView"

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        customAdapter = CustomAdapter(itemsList)
        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = customAdapter
        prepareItems()
    }

    private fun prepareItems() {
        //Create an instance of the word class, get the lst of words and add it to the itemsList
        val wordObj = Words()
        val fruits = wordObj.getWords()
        itemsList.addAll(fruits)
        customAdapter.notifyDataSetChanged()
    }
}