package br.com.tiagooliveira.heroesofmarvel.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.tiagooliveira.heroesofmarvel.R
import br.com.tiagooliveira.heroesofmarvel.model.Hero
import br.com.tiagooliveira.heroesofmarvel.utils.Utils
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_hero_detail.*
import kotlinx.android.synthetic.main.content_hero_detail.*

class HeroDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_detail)

        setSupportActionBar(toolbar)

        var bundle = intent.extras

        var hero = bundle.getSerializable(Utils.heroCode) as Hero

        toolbar_layout.title = hero.name

        fillDetails(hero)
    }

    fun fillDetails(hero: Hero){
        txtHeroDescription.text = hero.description

        val imagePath: String = hero.thumbnail.path + "." + hero.thumbnail.extension

        Picasso.get()
                .load(imagePath)
                .placeholder(R.color.colorAccent)
                .into(backdrop)
    }
}