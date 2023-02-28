package com.trinityjayd.wordguessgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var word = ""
        val submitbtn = findViewById<Button>(R.id.submitbtn)
        /**/


        submitbtn.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra("username", findViewById<EditText>(R.id.edtName).text.toString())
            startActivity(intent)

        }

    }


}