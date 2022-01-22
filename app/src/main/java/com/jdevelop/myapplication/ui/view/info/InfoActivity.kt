package com.jdevelop.myapplication.ui.view.info

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jdevelop.myapplication.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}