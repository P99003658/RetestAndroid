package com.ltts.examassessment

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.examassessment_main.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.examassessment_main2.*

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.examassessment_main2)

        button3.setOnClickListener {
            Toast.makeText(this, "LOGIN BUTTON CLICKED", Toast.LENGTH_LONG).show()
            // editTextTextPersonName2.setText(un)
            var myIntent = Intent(this, MainActivity3::class.java)
            startActivity(myIntent)

        }
    }
}