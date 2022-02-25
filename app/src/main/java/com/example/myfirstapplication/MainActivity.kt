package com.example.myfirstapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myfirstapplication.databinding.ActivityMainBinding
import java.math.BigDecimal

class MainActivity : AppCompatActivity(), CustomAdapter.OnItemClickListener {
    private lateinit var binding: ActivityMainBinding
    private val tasks = ArrayList<Task>()
    private val adapter = CustomAdapter(tasks, this)
    private var launcher: ActivityResultLauncher<Intent>? = null
    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val recyclerView = binding.recyclerView

        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)



        launcher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == RESULT_OK) {
                    val arrayExtra = result.data?.getStringArrayListExtra("key1")
                    tasks.add(Task(arrayExtra?.get(0), arrayExtra?.get(1)))
                    Log.d("myTag", "Result: ${arrayExtra?.get(0)}, ${arrayExtra?.get(1)}")
                }
            }

        binding.AddTaskButton.setOnClickListener {
            launcher?.launch(Intent(this, CreatingTaskActivity::class.java))
        }


        adapter.notifyDataSetChanged()
        recyclerView.adapter = adapter

    }

    override fun onItemClick(position: Int){
        tasks.removeAt(position)
        adapter.notifyItemRemoved(position)
    }
}