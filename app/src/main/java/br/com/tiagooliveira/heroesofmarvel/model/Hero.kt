package br.com.tiagooliveira.heroesofmarvel.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Hero(@SerializedName("id") val id: Int = 0,
                @SerializedName("name") val name: String = "",
                @SerializedName("description") val description: String = "",
                @SerializedName("thumbnail") val thumbnail: HeroThumbnail = HeroThumbnail()) : Serializable