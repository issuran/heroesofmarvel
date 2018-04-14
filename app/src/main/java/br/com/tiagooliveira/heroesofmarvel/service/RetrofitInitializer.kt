package br.com.tiagooliveira.heroesofmarvel.service

import br.com.tiagooliveira.heroesofmarvel.model.Hero
import com.squareup.moshi.Moshi
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class RetrofitInitializer {

    private val retrofit =  Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com:443")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

    // HeroesApiService interface reference
    fun heroService(): HeroesApiService{
        return retrofit.create(HeroesApiService::class.java)
    }
}