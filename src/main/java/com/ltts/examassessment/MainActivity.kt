package com.ltts.examassessment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.examassessment_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.examassessment_main)

        button.setOnClickListener {
            //var un=editTextTextPersonName2.text.toString()
            Toast.makeText(this, "REGISTER BUTTON CLICKED", Toast.LENGTH_LONG).show()
            // editTextTextPersonName2.setText(un)
            var myIntent = Intent(this, MainActivity::class.java)
            startActivity(myIntent)
        }
        button2.setOnClickListener {
            //var un=editTextTextPersonName2.text.toString()
            Toast.makeText(this, "LOGIN BUTTON CLICKED", Toast.LENGTH_LONG).show()
            // editTextTextPersonName2.setText(un)
            var myIntent = Intent(this, MainActivity2::class.java)
            startActivity(myIntent)
        }
    }
}