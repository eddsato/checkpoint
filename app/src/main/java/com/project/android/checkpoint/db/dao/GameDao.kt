package com.project.android.checkpoint.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import com.project.android.checkpoint.model.Game

@Dao
interface GameDao {

    @Insert
    fun insert(game: Game): Long
}