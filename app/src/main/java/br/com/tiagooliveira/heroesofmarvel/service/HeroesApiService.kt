package br.com.tiagooliveira.heroesofmarvel.service

import br.com.tiagooliveira.heroesofmarvel.model.Hero
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import java.util.*

interface HeroesApiService{

    @GET("/v1/public/characters")
    fun getHeroes(@Query("ts") timestamp: Int,
                  @Query("apikey") apikey: String,
                  @Query("hash") hash: String)
                    : Call<List<Hero>>

    @GET("/v1/public/characters/{id}")
    fun getHeroDetails(@Path("id")heroId: Int,
                       @Query("ts") timestamp: Int,
                       @Query("apikey") apikey: String,
                       @Query("hash") hash: String)
            : Call<List<Hero>>

}
