package com.example.recycleview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recycleview.databinding.ActivityMainBinding
import java.time.LocalDateTime
import java.time.LocalTime
import kotlin.system.measureNanoTime

class MainActivity : AppCompatActivity() {

    var item_count = 0
    var listdata:MutableList<item_data> = mutableListOf()
    val adapter = CustomAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager=LinearLayoutManager(this)

        binding.button.setOnClickListener {
            item_count += 1
            val title = "${item_count} Title"
            val name = "Test"
            val timestep = "12:34"
            listdata.add(item_data(name, title, timestep))
            adapter.replaceList(listdata)
        }

    }

}
