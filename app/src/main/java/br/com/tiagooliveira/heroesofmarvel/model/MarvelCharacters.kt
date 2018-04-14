package br.com.tiagooliveira.heroesofmarvel.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class MarvelCharacters(@SerializedName("code") val code: Int,
                            @SerializedName("data") val data: MarvelCharactersData)