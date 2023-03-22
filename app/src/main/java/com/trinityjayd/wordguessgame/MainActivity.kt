package com.trinityjayd.wordguessgame

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val submitbtn = findViewById<Button>(R.id.submitbtn)

        val listbtn = findViewById<Button>(R.id.wordlistbtn)

        submitbtn.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra("username", findViewById<EditText>(R.id.edtName).text.toString())
            startActivity(intent)

        }

        listbtn.setOnClickListener {
            val intent = Intent(this, ListActivity::class.java)
            startActivity(intent)
        }



    }


}