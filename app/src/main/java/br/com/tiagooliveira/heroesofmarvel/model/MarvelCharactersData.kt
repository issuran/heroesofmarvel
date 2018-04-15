package br.com.tiagooliveira.heroesofmarvel.model

import com.google.gson.annotations.SerializedName

data class MarvelCharactersData(@SerializedName("results") val result: ArrayList<Hero> = ArrayList())