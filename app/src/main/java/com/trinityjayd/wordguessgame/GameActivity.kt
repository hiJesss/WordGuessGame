package com.trinityjayd.wordguessgame

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible


class GameActivity : AppCompatActivity() {

    private var word = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        val greeting = findViewById<TextView>(R.id.greetingtxt)
        //greet the user with their name
        val myIntent = intent
        val name = myIntent.getStringExtra("username")
        greeting.text = "Hello ${name}!"

        //ask the user to guess a fruit
        val heading = findViewById<TextView>(R.id.headingtxt)
        heading.isVisible = true

        //predefined list of fruits
        val wordObj = Words()

        val fruits = wordObj.getWords()
        //randomly select a fruit
        val random = fruits.asSequence().shuffled().find { true }
        word = random.toString()

        val hintTextView = findViewById<TextView>(R.id.hinttxt)
        val guesstxt = findViewById<EditText>(R.id.guesstxt)
        val guessbtn = findViewById<Button>(R.id.guessbtn)

        //display the hint
        hintTextView.text = createHint(word)
        //display the guess text box and button
        guesstxt.isVisible = true
        guessbtn.isVisible = true

        var chances = 0
        guessbtn.setOnClickListener {
            if (chances < 5 ){
                chances += 1
                //get the word the user guessed
                val guess = guesstxt.text.toString()

                val result = findViewById<TextView>(R.id.resulttxt)
                result.text = ""

                val chance = findViewById<TextView>(R.id.chancestxt)
                //if their guess is correct, display the word
                if (guess.uppercase() == word.uppercase()) {
                    hintTextView.text = word
                    toastMessage()
                    chance.text = ""
                } else {
                    chance.text = "You have ${5-chances} chances left"
                    //if their guess is incorrect, display the hint
                    val hint = hintTextView.text.toString()
                    hintTextView.text = showCorrectLetters(word, guess,hint)
                    //if they eventually make up the word display the word
                    if (hintTextView.text.toString().uppercase() == word.uppercase()) {
                        toastMessage()
                        chance.text = ""
                    } else{
                        result.text = "Try again!"
                    }
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

    private fun showCorrectLetters(word: String, guess: String, hint: String): String {
        //break up the hint into a char array
        val chars = hint.toCharArray()
        //loop through the guess and the word
        //check each letter of the guess against each letter of the word
        for (i in guess.indices) {
            for (j in word.indices) {
                if (guess[i].uppercase() == word[j].uppercase()) {
                    chars[j] = guess[i]
                }
            }
        }
        //convert the char array back to a string
        return String(chars)
    }

    private fun toastMessage(){
        Toast.makeText(this, "You guessed the word!", Toast.LENGTH_SHORT).show()
    }
}