package br.com.tiagooliveira.heroesofmarvel.service

import br.com.tiagooliveira.heroesofmarvel.model.Hero
import br.com.tiagooliveira.heroesofmarvel.model.MarvelCharacters
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val heroesApiService: HeroesApiService

    init {
        val retrofit =  Retrofit.Builder()
                .baseUrl("https://gateway.marvel.com:443")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        heroesApiService = retrofit.create(HeroesApiService::class.java)
    }

    fun getAllHeroes(timestamp: Int, apikey: String, hash: String, offset: Int, limit: Int) : Call<MarvelCharacters>{
        return heroesApiService.getHeroes(timestamp, apikey, hash, offset, limit)
    }

    fun getHeroDetails(id: Int, timestamp: Int, apikey: String, hash: String) : Call<List<Hero>>{
        return heroesApiService.getHeroDetails(id, timestamp, apikey, hash)
    }
}