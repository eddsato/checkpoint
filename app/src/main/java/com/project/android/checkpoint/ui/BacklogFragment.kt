package com.project.android.checkpoint.ui


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.android.checkpoint.R
import com.project.android.checkpoint.adapter.GameAdapter
import com.project.android.checkpoint.model.Game
import com.project.android.checkpoint.model.GameViewModel
import kotlinx.android.synthetic.main.game_list.*

/**
 * A simple [Fragment] subclass.
 *
 */
class BacklogFragment : Fragment() {

    lateinit var gameListAdapter: GameAdapter
    lateinit var gameViewModel: GameViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.game_list, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        gameListAdapter = GameAdapter()
        games_list.layoutManager = LinearLayoutManager(context)
        games_list.adapter = gameListAdapter
        gameViewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        gameViewModel.getBacklogGames().observe(this,
                Observer<List<Game>> {t -> gameListAdapter.swapGames(t!!) })
    }
}
