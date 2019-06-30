package com.project.android.checkpoint.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.android.checkpoint.R
import com.project.android.checkpoint.service.model.Game
import kotlinx.android.synthetic.main.game_item.view.*

class GameAdapter : RecyclerView.Adapter<GameAdapter.GameHolder>() {

    private var games: List<Game> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameHolder {
        return GameHolder(
                LayoutInflater.from(parent.context)
                        .inflate(R.layout.game_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: GameHolder, position: Int) {
        holder.bind(games[position])
    }

    override fun getItemCount() = games.size

    fun swapGames(games: List<Game>) {
        this.games = games
        notifyDataSetChanged()
    }

    class GameHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(game: Game) = with(itemView) {
            tv_game_title.text = game.gameTitle
            tv_platform.text = game.plataform
        }
    }
}