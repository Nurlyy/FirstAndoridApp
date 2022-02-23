package com.example.myfirstapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapplication.databinding.ActivityMainBinding
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val recyclerView = binding.recyclerView

        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        val tasks = ArrayList<Task>()

        tasks.add(Task("Read a book", "read a book Steve Jobs by Walter Isaacson"))
        tasks.add(Task("Learn Kotlin", "Learn more about RecyclerView in Kotlin"))
        tasks.add(Task("Have a dinner" ))
        tasks.add(Task(taskDescription = "wash dishes"))

        val adapter = CustomAdapter(tasks)

        recyclerView.adapter = adapter
    }
}