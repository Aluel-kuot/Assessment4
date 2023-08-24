package com.aluel.assessment4.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aluel.assessment4.R
import com.aluel.assessment4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()


































