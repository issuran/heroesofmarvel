package br.com.tiagooliveira.heroesofmarvel.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.ViewHolder
import br.com.tiagooliveira.heroesofmarvel.R
import br.com.tiagooliveira.heroesofmarvel.adapter.HeroListAdapter
import br.com.tiagooliveira.heroesofmarvel.model.Hero

class MainActivity : AppCompatActivity() {

    var mRecyclerView: RecyclerView? = null
    var mLayoutManager: GridLayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecyclerView = findViewById(R.id.recyclerViewHeroes)

        // use a grid layout manager
        mLayoutManager = GridLayoutManager(this, 2)
        mRecyclerView!!.layoutManager = mLayoutManager

        val mAdapter = HeroListAdapter(this)

        mRecyclerView!!.adapter = mAdapter

        val arrayHeroes: ArrayList<Hero> = ArrayList()
        for(i in 1..25){
            arrayHeroes.add(Hero())
        }

        // specify an adapter
        mAdapter.setHeroesList(arrayHeroes)
    }
}
