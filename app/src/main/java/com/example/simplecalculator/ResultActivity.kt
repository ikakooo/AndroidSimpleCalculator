package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }


    private fun init(){
        val resultID = intent.getStringExtra("resultID")
        resultTextViewID.text =if (resultID.isNullOrEmpty()) "Error" else  resultID
    }
}