package com.cs407.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val firstNumber = findViewById<EditText>(R.id.myTextField)
        val secondNumber = findViewById<EditText>(R.id.myTextField2)
        val addButton = findViewById<Button>(R.id.button)
        addButton.setOnClickListener{
            val  num1 = firstNumber.text.toString()
            val num2 = secondNumber.text.toString()
            val result = num1 + num2
        }

        val subButton = findViewById<Button>(R.id.button2)
        subButton.setOnClickListener{
            val num1 = firstNumber.text.toString()}
        val mulButton = findViewById<Button>(R.id.button3)
        mulButton.setOnClickListener{
            val  num1 = firstNumber.text.toString()}
        val divButton = findViewById<Button>(R.id.button4)
        divButton.setOnClickListener{
            val  num1 = firstNumber.text.toString()}
    }

    fun doAdd(view: View) {}

}