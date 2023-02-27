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

        val hintTextView = findViewById<TextView>(R.id.hinttxt)
        val guesstxt = findViewById<EditText>(R.id.guesstxt)
        val guessbtn = findViewById<Button>(R.id.guessbtn)

        submitbtn.setOnClickListener {
            //greet the user
            greeting.text = "Hello ${name.text}!"
            submitbtn.isVisible = false
            name.isVisible = false

            //ask the user to guess a fruit
            val heading = findViewById<TextView>(R.id.headingtxt)
            heading.isVisible = true

            //predefined list of fruits
            val fruits = listOf("Apple", "Banana", "Orange", "Pear", "Grape", "Strawberry", "Pineapple", "Watermelon")
            //randomly select a fruit
            val random = fruits.asSequence().shuffled().find{true}
            val word = random.toString()

            //display the hint
            hintTextView.text = createHint(word)
            //display the guess text box and button
            guesstxt.isVisible = true
            guessbtn.isVisible = true
        }

        guessbtn.setOnClickListener {
            //get the word the user guessed


        }


    }

    fun createHint(word: String): String {
        val hint = word.toCharArray()
        for (i in 0 until hint.size) {
            if (hint[i] != ' ') {
                hint[i] = '_'
            }
        }
        return String(hint)
    }

    fun showCorrectLetters(word: String, hint: String, letter: Char): String {
        val hintArray = hint.toCharArray()
        for (i in 0 until word.length) {
            if (word[i] == letter) {
                hintArray[i] = letter
            }
        }
        return String(hintArray)
    }

}