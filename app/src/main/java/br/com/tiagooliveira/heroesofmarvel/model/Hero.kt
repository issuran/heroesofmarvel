package br.com.tiagooliveira.heroesofmarvel.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class Hero(@SerializedName("id") val id: Int = 0,
                @SerializedName("name") val name: String = "",
                @SerializedName("description") val description: String = "",
                val image: String = "http://freepngimg.com/download/megaman/20003-5-megaman.png",
                @SerializedName("thumbnail") val thumbnail: HeroThumbnail = HeroThumbnail())