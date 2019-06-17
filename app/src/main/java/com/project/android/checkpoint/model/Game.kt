package com.project.android.checkpoint.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Game (
        var gameTitle: String,
        var plataform: String,
        var genre: String,
        var status: String
) {
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0
}