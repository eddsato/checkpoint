package com.project.android.checkpoint.service.db.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.project.android.checkpoint.service.model.Game

@Dao
interface GameDao {

    @Insert
    fun insert(game: Game): Long

    @Query("SELECT * FROM Game WHERE status = :playingStatus")
    fun getPlayingGames(playingStatus: String): LiveData<List<Game>>

    @Query("SELECT * FROM Game WHERE status = :backlogStatus")
    fun getBacklogGames(backlogStatus: String): LiveData<List<Game>>

    @Query("SELECT * FROM Game WHERE status = :finishedStatus")
    fun getFinishedGames(finishedStatus: String): LiveData<List<Game>>
}