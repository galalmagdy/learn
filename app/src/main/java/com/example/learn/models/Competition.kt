package com.example.learn.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "competitions")
data class Competition(
    @PrimaryKey val id: Int,
    val area: Area,
    val name: String,
    val code: String,
    val type: String,
    val emblem: String?,
    val plan: String,
    val currentSeason: Season,
    val numberOfAvailableSeasons: Int,
    val lastUpdated: String
)