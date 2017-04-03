package com.example.joachim.buttsandpeepee

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var input : EditText
    lateinit var output : TextView
    lateinit var click : Button
    private fun checkInput(input : String) {
        if (input is String) {
            output.setText("Good job nerd")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        output = findViewById(R.id.textView) as TextView
        input = findViewById(R.id.editText) as EditText
        click = findViewById(R.id.button) as Button
        click.setOnClickListener { view -> checkInput(input.toString()) }

    }
}
