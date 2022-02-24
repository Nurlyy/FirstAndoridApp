package com.example.myfirstapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myfirstapplication.databinding.ActivityCreatingTaskBinding
import com.example.myfirstapplication.databinding.ActivityMainBinding

class CreatingTaskActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreatingTaskBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreatingTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.addButton.setOnClickListener{
            val i = Intent()
            var arrayExtra = arrayListOf<String>(binding.editTextTaskName.text.toString(), binding.editTextTaskDescription.text.toString())
            i.putExtra("key1", arrayExtra)
            setResult(RESULT_OK, i)
            finish()
        }

    }
}