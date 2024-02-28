package com.example.learn.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "areas")
data class Area(
    @PrimaryKey val id: Int,
    val name: String,
    val code: String,
    val flag: String?
)
