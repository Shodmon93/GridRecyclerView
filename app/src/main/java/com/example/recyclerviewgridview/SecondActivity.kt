package com.example.recyclerviewgridview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.recyclerviewgridview.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var bundle : Bundle? = intent.extras

        bundle.let {
            bundle?.apply {
                Glide
                    .with(this@SecondActivity)
                    .load(getInt("key"))
                    .into(binding.secondIMG)
            }
        }
    }
}