package br.com.tiagooliveira.heroesofmarvel.model

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import java.io.Serializable

data class HeroThumbnail (@SerializedName("path") val path: String = "http://freepngimg.com/download/megaman/20003-5-megaman",
                          @SerializedName("extension") val extension: String = "png") : Serializable