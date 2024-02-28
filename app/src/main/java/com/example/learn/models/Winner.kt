package com.example.learn.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "winners")
data class Winner(
    @PrimaryKey val id: Int,
    val name: String,
    val shortName: String,
    val tla: String,
    val crest: String,
    val address: String,
    val website: String,
    val founded: Int,
    val clubColors: String,
    val venue: String?,
    val lastUpdated: String
)