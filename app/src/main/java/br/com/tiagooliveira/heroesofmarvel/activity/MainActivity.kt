package br.com.tiagooliveira.heroesofmarvel.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import br.com.tiagooliveira.heroesofmarvel.R
import br.com.tiagooliveira.heroesofmarvel.adapter.HeroListAdapter
import br.com.tiagooliveira.heroesofmarvel.model.Hero
import br.com.tiagooliveira.heroesofmarvel.model.MarvelCharacters
import br.com.tiagooliveira.heroesofmarvel.service.RetrofitInitializer
import br.com.tiagooliveira.heroesofmarvel.utils.Utils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    var mRecyclerView: RecyclerView? = null
    var mLayoutManager: GridLayoutManager? = null
    var mAdapter: HeroListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecyclerView = findViewById(R.id.recyclerViewHeroes)

        // use a grid layout manager
        mLayoutManager = GridLayoutManager(this, 1)
        mRecyclerView!!.layoutManager = mLayoutManager

        mAdapter = HeroListAdapter(this)

        mRecyclerView!!.adapter = mAdapter

        retrieveHeroes()
    }

    fun retrieveHeroes(){
        val call = RetrofitInitializer().getAllHeroes(Utils.timestamp, Utils.apikey, Utils.hash, Utils.offset, Utils.limit)
        call.enqueue(object : Callback<MarvelCharacters>{
            override fun onFailure(call: Call<MarvelCharacters>?, t: Throwable?) {
                Log.d("RETROFIT","FALHOU")
            }

            override fun onResponse(call: Call<MarvelCharacters>?, response: Response<MarvelCharacters>?) {
                response?.let {
                    val heroes = it.body()

                    val arrayHeroes: ArrayList<Hero> = ArrayList()

                    if(heroes != null && heroes.data.result.size > 0 && mAdapter != null){
                        arrayHeroes.addAll(heroes.data.result)
                        mAdapter!!.setHeroesList(arrayHeroes)
                        Utils.offset += 100
                    }

                    Log.d("RETROFIT","DEU CERTO")
                }
            }

        })
    }
}
