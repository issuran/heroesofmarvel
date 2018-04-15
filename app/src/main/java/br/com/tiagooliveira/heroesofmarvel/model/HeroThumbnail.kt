package br.com.tiagooliveira.heroesofmarvel.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class HeroThumbnail (@SerializedName("path") val path: String = "",
                          @SerializedName("extension") val extension: String = "") : Serializable