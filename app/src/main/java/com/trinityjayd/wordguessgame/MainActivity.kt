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

        var word = ""
        val submitbtn = findViewById<Button>(R.id.submitbtn)


        val hintTextView = findViewById<TextView>(R.id.hinttxt)
        val guesstxt = findViewById<EditText>(R.id.guesstxt)
        val guessbtn = findViewById<Button>(R.id.guessbtn)


        submitbtn.setOnClickListener {
            //greet the user
            val name = findViewById<EditText>(R.id.edtName)
            val greeting = findViewById<TextView>(R.id.greetingtxt)
            greeting.text = "Hello ${name.text}!"
            submitbtn.isVisible = false
            name.isVisible = false

            //ask the user to guess a fruit
            val heading = findViewById<TextView>(R.id.headingtxt)
            heading.isVisible = true

            //predefined list of fruits
            val fruits = listOf(
                "Apple",
                "Banana",
                "Orange",
                "Pear",
                "Grape",
                "Strawberry",
                "Pineapple",
                "Watermelon"
            )
            //randomly select a fruit
            val random = fruits.asSequence().shuffled().find { true }
            word = random.toString()

            //display the hint
            hintTextView.text = createHint(word)
            //display the guess text box and button
            guesstxt.isVisible = true
            guessbtn.isVisible = true
        }

        guessbtn.setOnClickListener {
            //get the word the user guessed
            val guess = guesstxt.text.toString()

            val result = findViewById<TextView>(R.id.resulttxt)

            if (guess == word) {
                hintTextView.text = word
                result.text = "You guessed the word!"
            } else {
                hintTextView.text = showCorrectLetters(word, guess)
                result.text = "Try again!"
            }


        }

    }

    private fun createHint(word: String): String {
        val hint = word.toCharArray()
        for (i in hint.indices) {
            if (hint[i] != ' ') {
                hint[i] = '_'
            }
        }
        return String(hint)
    }

    private fun showCorrectLetters(word: String, guess: String): String {
        var hint = createHint(word)
        val chars = hint.toCharArray()
        for(i in guess.indices){
            for(j in word.indices){
                if(guess[i] == word[j]){
                    chars[j] = guess[i]
                }
            }
        }
        hint = String(chars)
        return hint
    }

}