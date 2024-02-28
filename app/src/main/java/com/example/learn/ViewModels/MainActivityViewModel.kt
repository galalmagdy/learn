package com.example.learn.ViewModels

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.learn.Repo.CompetitionRepo
import com.example.learn.SharedPref.SharedPrefManager
import com.example.learn.models.Competition
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(private val repository : CompetitionRepo):ViewModel() {
    val _Competition = MutableLiveData<List<Competition>>()
    val Competition:LiveData<List<Competition>> get() = _Competition

    init{
        getAllCompetitions()
    }
    private fun getAllCompetitions()=viewModelScope.launch { repository.getCompetitions().let { response ->
        if (response.isSuccessful){

                _Competition.postValue(response.body()?.competitions )




        }else{
        Log.e("ERROR_MainActivityViewModel","Error")
            }
        }
    }



}