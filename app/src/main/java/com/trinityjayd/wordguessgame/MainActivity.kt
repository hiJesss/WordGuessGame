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
            //greet the user with their name
            greeting.text = "Hello ${name.text}!"

            //make the name component invisible
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

            //if their guess is correct, display the word
            if (guess.uppercase() == word.uppercase()) {
                hintTextView.text = word
                result.text = "You guessed the word!"
            } else {
                //if their guess is incorrect, display the hint
                hintTextView.text = showCorrectLetters(word, guess)
                //if they eventually make up the word display the word
                if (hintTextView.text == word) {
                    result.text = "You guessed the word!"
                } else{
                    result.text = "Try again!"
                }
            }


        }

    }

    private fun createHint(word: String): String {
        val hint = word.toCharArray()
        //create the hint using asterisks for each letter
        for (i in hint.indices) {
            if (hint[i] != ' ') {
                hint[i] = '*'
            }
        }
        return String(hint)
    }

    private fun showCorrectLetters(word: String, guess: String): String {
        var hint = createHint(word)
        //break up the hint into a char array
        val chars = hint.toCharArray()
        //loop through the guess and the word
        //check each letter of the guess against each letter of the word
        for(i in guess.indices){
            for(j in word.indices){
                if(guess[i].uppercase() == word[j].uppercase()){
                    chars[j] = guess[i]
                }
            }
        }
        //convert the char array back to a string
        hint = String(chars)
        return hint
    }

}