package com.jdevelop.myapplication.ui.view.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jdevelop.myapplication.databinding.ActivitySplashBinding
import com.jdevelop.myapplication.ui.view.info.InfoRouter
import com.jdevelop.myapplication.ui.view.main.MainRouter

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListeners()
    }

    private fun setupListeners() {
        binding.buttonParty.setOnClickListener {
            MainRouter().launch(this)
        }
        binding.buttonInfo.setOnClickListener {
            InfoRouter().launch(this)
        }
    }
}