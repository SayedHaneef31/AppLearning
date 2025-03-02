package com.inster.exampleeeeeeee

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class UsersAdapter(val context: Context, val userList: List<Users>) : RecyclerView.Adapter<UsersViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cards_activity, parent, false)
        return UsersViewHolder(itemView)
     }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        val currentUser = userList[position]
        holder.textViewName.text = currentUser.name
        holder.textViewAge.text = currentUser.age.toString()
        holder.textViewGmail.text = currentUser.gmail
        // Bind other user details to respective TextViews if needed

        holder.itemView.setOnClickListener {
            val intentToUpdate= Intent(context,update_activity::class.java)
            intentToUpdate.putExtra("NAME",currentUser.name)
            intentToUpdate.putExtra("AGE",currentUser.age)
            intentToUpdate.putExtra("GMAIL",currentUser.gmail)
//            intentToUpdate.putExtra("ID",currentUser.userId)
            context.startActivity(intentToUpdate)



        }
    }


    override fun getItemCount() = userList.size
}
