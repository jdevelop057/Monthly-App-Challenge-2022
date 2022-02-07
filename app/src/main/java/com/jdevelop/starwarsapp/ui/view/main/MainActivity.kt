package com.jdevelop.starwarsapp.ui.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jdevelop.starwarsapp.R
import com.jdevelop.starwarsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}