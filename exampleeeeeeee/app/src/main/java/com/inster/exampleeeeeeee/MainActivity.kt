package com.inster.exampleeeeeeee

import android.content.Intent
import android.os.Bundle
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.inster.exampleeeeeeee.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    lateinit var bindMain: ActivityMainBinding

    val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    val reference: DatabaseReference =database.reference.child("Tokens")

    // Inside onCreate() method of MainActivity
    var userList=ArrayList<Users>()
    lateinit var usersAdapter: UsersAdapter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindMain=ActivityMainBinding.inflate(layoutInflater)
        val view=bindMain.root
        setContentView(view)
        setSupportActionBar(bindMain.toolbarrrr)

        bindMain.floatinggggg.setOnClickListener{
            val intenttoAdd= Intent(this@MainActivity,AddDetailsActivity::class.java)
            startActivity(intenttoAdd)

        }
        retrieveData()


    }
    fun retrieveData()
    {
        reference.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                userList.clear()

                for (eachUser in snapshot.children) {
                    val user = eachUser.getValue(Users::class.java)
                    user?.let {
                        userList.add(it)
                    }
                }

                // Now userList contains all Users objects retrieved from the database
                // Initialize and set up your RecyclerView adapter here
                usersAdapter = UsersAdapter(this@MainActivity, userList)
                bindMain.recyclerViewwwww.layoutManager=LinearLayoutManager(this@MainActivity)
                bindMain.recyclerViewwwww.adapter=usersAdapter
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}