package com.project.android.checkpoint.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Game (
        @PrimaryKey(autoGenerate = true)
        val id: Long = 0,
        val gameTitle: String,
        val plataform: String,
        val genre: String,
        val playingStatus: String
)