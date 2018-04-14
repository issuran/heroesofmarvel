package br.com.tiagooliveira.heroesofmarvel.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class MarvelCharactersData(@SerializedName("results") val result: ArrayList<Hero> = ArrayList())