package br.com.tiagooliveira.heroesofmarvel.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.tiagooliveira.heroesofmarvel.R
import br.com.tiagooliveira.heroesofmarvel.model.Hero
import br.com.tiagooliveira.heroesofmarvel.utils.Utils
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details_hero.*

class HeroDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_hero)

        var bundle = intent.extras

        var hero = bundle.getSerializable(Utils.heroCode) as Hero

        fillDetails(hero)
    }

    fun fillDetails(hero: Hero){
        txtHeroTitle.text = hero.name
        txtHeroDescription.text = hero.description

        val imagePath: String = hero.thumbnail.path + "." + hero.thumbnail.extension

        Picasso.get()
                .load(imagePath)
                .placeholder(R.color.colorAccent)
                .into(imgHero)
    }
}