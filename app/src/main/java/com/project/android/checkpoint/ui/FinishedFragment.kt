package com.project.android.checkpoint.ui


import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.project.android.checkpoint.R
import com.project.android.checkpoint.adapter.GameAdapter
import com.project.android.checkpoint.model.GameViewModel
import kotlinx.android.synthetic.main.game_list.*

/**
 * A simple [Fragment] subclass.
 *
 */
class FinishedFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.game_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        val adapter = GameAdapter()
        games_list.layoutManager = LinearLayoutManager(context)
        games_list.adapter = adapter

        val gameViewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)

        super.onActivityCreated(savedInstanceState)
    }
}
