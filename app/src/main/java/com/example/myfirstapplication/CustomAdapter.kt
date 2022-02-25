package com.example.myfirstapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val tasksList:ArrayList<Task>, private val listener: OnItemClickListener): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


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

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView), View.OnClickListener {

        fun bindItems(task: Task){
            val textViewTaskName = itemView.findViewById(R.id.textViewTaskName) as TextView
            val textViewTaskDescription = itemView.findViewById(R.id.textViewTaskDescription) as TextView
            textViewTaskName.text = task.taskName
            textViewTaskDescription.text = task.taskDescription
        }

        init{
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION){
                listener.onItemClick(position)
            }
        }
    }
    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
}