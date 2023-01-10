package com.example.recyclerviewgridview

import android.content.Intent
import android.os.Bundle
import android.widget.GridLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.example.recyclerviewgridview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    /*================================================*/
    private lateinit var binding: ActivityMainBinding
    private lateinit var gridAdapter: GridViewAdapter
    /*================================================*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*================================================*/
        gridAdapter = GridViewAdapter { position -> onImageClickListener(position) }
        gridAdapter.setData(DataModule.setData())
        /*================================================*/
        binding.imageViewRV.apply {
            layoutManager = GridLayoutManager(this@MainActivity, 3,GridLayoutManager.HORIZONTAL,false)
            adapter = gridAdapter
        }
    }

    fun onImageClickListener(dataPosition: ImageData){
        Toast.makeText(this@MainActivity, "${dataPosition.name}", Toast.LENGTH_SHORT).show()

        val intent = Intent(this@MainActivity,SecondActivity::class.java)
        intent.putExtra("key", dataPosition.image)
        startActivity(intent)
    }
}