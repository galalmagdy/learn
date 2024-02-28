package com.example.learn.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "seasons")
data class Season(
    @PrimaryKey val id: Int,
    val startDate: String,
    val endDate: String,
    val currentMatchday: Int,
    val winner: Winner?
)
