package com.jdevelop.starwarsapp.ui.view.splash

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jdevelop.starwarsapp.databinding.ActivitySplashBinding
import com.jdevelop.starwarsapp.ui.component.progressbar.ComponentProgressBar

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private lateinit var componentProgressBar: ComponentProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    private fun setup() {
        componentProgressBar = binding.componentProgressBar
        componentProgressBar.setProgressBarColor(Color.CYAN)
    }
}