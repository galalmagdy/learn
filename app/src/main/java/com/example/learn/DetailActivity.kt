package com.example.learn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import com.bumptech.glide.Glide
import com.example.learn.databinding.ActivityDetailBinding
import com.example.learn.models.Competition
import com.google.gson.Gson

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val json = intent.getStringExtra("competition")

        val competition = Gson().fromJson(json, Competition::class.java)
        Glide.with(this)
            .load(competition.emblem)
            .placeholder(R.drawable.ic_launcher_background)
            .error(android.R.drawable.ic_dialog_alert)
            .into(binding.dmblemIm)
        binding.dname.text = "Name :" + competition.name
        binding.dtype.text = "Type :" + competition.type
        binding.darea.text = "Area :" + competition.area.name
        binding.dstart.text = "Start :" + competition.currentSeason.startDate
        binding.dend.text = "End :" + competition.currentSeason.endDate

        ///binding.competition = competition
    }
}