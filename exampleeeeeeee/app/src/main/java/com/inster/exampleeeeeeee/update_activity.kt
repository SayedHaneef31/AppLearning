package com.inster.exampleeeeeeee

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class update_activity : AppCompatActivity()
{
    lateinit var goBack:Button
    lateinit var updateButton: Button

    lateinit var updateName: TextView
    lateinit var updateAge: TextView
    lateinit var updateGmail: TextView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        updateName=findViewById(R.id.addNameeeee)
        updateAge=findViewById(R.id.addAgeeee)
        updateGmail=findViewById(R.id.addGmailllll)

        updateButton=findViewById(R.id.buttonnn)
        goBack=findViewById(R.id.backkkkk)



        goBack.setOnClickListener {
            finish()
        }
        updateButton.setOnClickListener {
            val name=intent.getStringExtra("NAME")
            val age=intent.getStringExtra("AGE")
            val gmaill=intent.getStringExtra("GMAIL")

            updateName
        }

    }

}