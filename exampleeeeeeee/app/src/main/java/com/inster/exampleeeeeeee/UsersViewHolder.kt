package com.inster.exampleeeeeeee

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UsersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val textViewName: TextView = itemView.findViewById(R.id.textViewName)
    val textViewAge: TextView = itemView.findViewById(R.id.textViewAge)
    val textViewGmail: TextView = itemView.findViewById(R.id.textViewGmail)
    // Add references to other TextViews if needed
}
