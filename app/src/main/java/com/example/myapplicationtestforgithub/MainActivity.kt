package com.example.myapplicationtestforgithub

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var count = 0

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val textCount = findViewById<TextView>(R.id.textCount)
        val buttonReset = findViewById<Button>(R.id.buttonReset)
        val buttonMinus = findViewById<Button>(R.id.buttonMinus)

        buttonMinus.setOnClickListener {
            count--
            textCount.text = count.toString()
        }
        buttonReset.setOnClickListener {
            count = 0
            textCount.text = count.toString()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}