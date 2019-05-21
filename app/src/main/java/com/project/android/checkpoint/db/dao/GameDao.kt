package com.project.android.checkpoint.db.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.project.android.checkpoint.model.Game

@Dao
interface GameDao {

    @Query("SELECT * FROM game WHERE playingStatus LIKE :status")
    fun allFinished(status: String): List<Game>

//    fun add(vararg game: Game)
}