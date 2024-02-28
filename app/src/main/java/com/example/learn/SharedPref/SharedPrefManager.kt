package com.example.learn.SharedPref

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.learn.models.Competition
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import javax.inject.Inject

class SharedPrefManager @Inject constructor(private val context: Context) {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("my_shared_pref", Context.MODE_PRIVATE)

    private val gson = Gson()

    fun saveCompetitions(competitions: List<Competition>) {
        val json = gson.toJson(competitions)
        sharedPreferences.edit {
            putString("competitions", json)
        }
    }

    fun getCompetitions(): List<Competition> {
        val json = sharedPreferences.getString("competitions", null)
        return if (json != null) {
            gson.fromJson(json, object : TypeToken<List<Competition>>() {}.type)
        } else {
            emptyList()
        }
    }
}