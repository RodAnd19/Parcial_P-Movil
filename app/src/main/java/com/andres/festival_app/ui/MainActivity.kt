package com.andres.festival_app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.andres.festival_app.R
import com.andres.festival_app.databinding.ActivityMainBinding
import com.andres.festival_app.databinding.FragmentFestivalItemBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}