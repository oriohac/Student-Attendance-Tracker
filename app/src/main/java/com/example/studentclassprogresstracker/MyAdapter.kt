package com.example.studentclassprogresstracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.user_item.view.*

class MyAdapter(private val userList : ArrayList<UserL>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
     val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false)
       return MyViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = userList[position]
        holder.present.text = currentitem.present
        holder.id.text = currentitem.id

    }

    override fun getItemCount(): Int {
       return userList.size
    }
    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val present : TextView = itemView.tvsignindata
        val id : TextView = itemView.tvsignindataid

    }
}
