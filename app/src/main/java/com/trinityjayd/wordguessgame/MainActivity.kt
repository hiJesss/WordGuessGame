package com.trinityjayd.wordguessgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val name = findViewById<EditText>(R.id.edtName)
        val submitbtn = findViewById<Button>(R.id.submitbtn)
        val greeting = findViewById<TextView>(R.id.greetingtxt)
        submitbtn.setOnClickListener {
            greeting.text = "Hello ${name.text}!"
            submitbtn.isVisible = false
            name.isVisible = false
        }

        val fruits = listOf("Apple", "Banana", "Orange", "Pear", "Grape", "Strawberry", "Pineapple", "Watermelon")
        val random = fruits.asSequence().shuffled().find{true}
        val word = random.toString()
        greeting.text = word
    }

}