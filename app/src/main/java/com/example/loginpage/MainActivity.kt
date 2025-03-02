package com.example.loginpage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.provider.Telephony.Mms.Intents
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity()
    {
        lateinit var name: TextView
        lateinit var phone: TextView
        lateinit var submitButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        name=findViewById(R.id.namee)
        submitButton=findViewById(R.id.submitt)
        phone=findViewById(R.id.phonee)

        submitButton.setOnClickListener {

            var intent= Intent(this@MainActivity,LoginPageActivity::class.java)
            startActivity(intent)

        }





    }
}