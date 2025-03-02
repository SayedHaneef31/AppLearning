package com.inster.exampleeeeeeee


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddDetailsActivity : AppCompatActivity()
{
    lateinit var addName:TextView
    lateinit var addGmail:TextView
    lateinit var addAge:TextView

    lateinit var button: Button

    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    val reference: DatabaseReference =database.reference.child("Tokens")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_details)

        addName=findViewById(R.id.addNameeeee)
        addGmail=findViewById(R.id.addGmailllll)
        addAge=findViewById(R.id.addAgeeee)

        button=findViewById(R.id.back_buttonnnn)

        button.setOnClickListener {
            addUserData()
        }



    }
    fun addUserData()
    {
        val name: String = addName.text.toString().trim()
        val age: String = addAge.text.toString().trim()
        val gmail: String = addGmail.text.toString().trim()

        if (name.isEmpty() || age.isEmpty() || gmail.isEmpty()) {
            // Show error message or handle empty fields as per your app's logic
            Toast.makeText(applicationContext, "Please fill all fields", Toast.LENGTH_SHORT).show()
            return
        }

        val id:String = reference.push().key.toString()
        val user= Users(id,name, gmail,age.toInt())

        reference.child(id).setValue(user).addOnCompleteListener { Task->
            if (Task.isSuccessful)
            {
                Toast.makeText(applicationContext,"User Added",Toast.LENGTH_SHORT).show()
                finish()
            }
            else
            {
                Toast.makeText(applicationContext,
                    Task.exception.toString(),
                    Toast.LENGTH_LONG).show()
                addName.text=""
                addAge.text=""
                addGmail.text=""


            }
        }


    }
}