package com.example.myfirstapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val tasksList:ArrayList<Task>): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        holder.bindItems(tasksList[position])

    }

    override fun getItemCount(): Int {
        return tasksList.size
    }

    class  ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        fun bindItems(task: Task){
            val textViewTaskName = itemView.findViewById(R.id.textViewTaskName) as TextView
            val textViewTaskDescription = itemView.findViewById(R.id.textViewTaskDescription) as TextView
            textViewTaskName.text = task.taskName
            textViewTaskDescription.text = task.taskDescription
        }

    }

    fun addTask(){
        notifyDataSetChanged()
    }


}