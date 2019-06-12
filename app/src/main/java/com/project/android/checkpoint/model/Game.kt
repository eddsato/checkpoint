package com.project.android.checkpoint.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Game (
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,
        var gameTitle: String,
        var plataform: String,
        var genre: String,
        var playingStatus: String
)