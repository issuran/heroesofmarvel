package br.com.tiagooliveira.heroesofmarvel.model

import com.squareup.moshi.Json

data class Hero(@Json(name="id") val id: Int = 0,
                @Json(name="name") val name: String = "",
                @Json(name="description") val description: String = "",
                val image: String = "http://freepngimg.com/download/megaman/20003-5-megaman.png",
                @Json(name="thumbnail") val thumbnail: HeroThumbnail = HeroThumbnail())