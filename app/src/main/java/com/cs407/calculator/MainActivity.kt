package com.cs407.calculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
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
        val result = findViewById<TextView>(R.id.myTextField)
        val addButton = findViewById<Button>(R.id.button)
        fun operatorAction(operator: String) {
            val  num1 = firstNumber.text.toString().toFloatOrNull()?: throw NumberFormatException("Invalid number format")
            val num2 = secondNumber.text.toString().toFloatOrNull()?: throw NumberFormatException("Invalid number format")
            if(num2 == 0.0F){
                Toast.makeText(this, "cannot divide by 0", Toast.LENGTH_SHORT).show()
                return
            }

            var res: Float = 0.0f
            when(operator)
            {
                "+"->res = num1+num2
                "-"->res = num1-num2
                "*"->res = num1*num2
                "/"->res = num1/num2
            }
            val intent = Intent(this, Result::class.java)
            //pass the user to a new activity
            intent.putExtra("result", res)
            //start the activity
            startActivity(intent)
        }
        addButton.setOnClickListener{
            operatorAction("+")
        }

        val subButton = findViewById<Button>(R.id.button2)
        subButton.setOnClickListener{
            operatorAction("-")
            }


        val mulButton = findViewById<Button>(R.id.button3)
        mulButton.setOnClickListener{
            operatorAction("*")
        }
        val divButton = findViewById<Button>(R.id.button4)
        divButton.setOnClickListener{
            operatorAction("/")
        }



    }



}












