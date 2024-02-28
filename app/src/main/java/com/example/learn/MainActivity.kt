package com.example.learn

import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.learn.Adapter.CompetitionAdapter
import com.example.learn.SharedPref.SharedPrefManager
import com.example.learn.ViewModels.MainActivityViewModel
import com.example.learn.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var adapter : CompetitionAdapter
    private lateinit var viewModel : MainActivityViewModel

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val sharedPrefManager = SharedPrefManager(this)
        if (isNetworkAvailable()){
            viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
            viewModel.Competition.observe(this,{response ->
                binding.CompRecyclerView.layoutManager = LinearLayoutManager(this)
                sharedPrefManager.saveCompetitions(response)
                adapter = CompetitionAdapter(response)
                binding.CompRecyclerView.adapter = adapter
            })
        }else{
            binding.CompRecyclerView.layoutManager = LinearLayoutManager(this)
            adapter = CompetitionAdapter(sharedPrefManager.getCompetitions())
            binding.CompRecyclerView.adapter = adapter

        }

    }
}