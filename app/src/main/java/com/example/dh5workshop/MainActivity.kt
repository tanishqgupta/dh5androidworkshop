package com.example.dh5workshop

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var textView: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.intro_text)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            if (textView.text == "Hello World!") {
                textView.text = "Goodbye World!"
            } else {
                textView.text = "Hello World!"
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
            }
        }


    }
}
