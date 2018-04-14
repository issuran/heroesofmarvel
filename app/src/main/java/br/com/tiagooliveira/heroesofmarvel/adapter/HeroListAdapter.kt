package br.com.tiagooliveira.heroesofmarvel.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import br.com.tiagooliveira.heroesofmarvel.R
import br.com.tiagooliveira.heroesofmarvel.model.Hero
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.row_hero.view.*

class HeroListAdapter(context: Context) : RecyclerView.Adapter<HeroListAdapter.HeroHolder>() {

    var mContext: Context = context
    var mHeroList: ArrayList<Hero> = ArrayList()
    var mInflater: LayoutInflater = LayoutInflater.from(mContext)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroListAdapter.HeroHolder {
        val view = mInflater.inflate(R.layout.row_hero, parent, false)
        return HeroHolder(view)
    }

    override fun getItemCount(): Int {
        return if (mHeroList == null) 0 else mHeroList.size
    }

    override fun onBindViewHolder(holder: HeroHolder, position: Int) {
        val hero = mHeroList.get(position)

        holder.bindHero(hero, position)

    }

    fun setHeroesList(arrayHeroes: ArrayList<Hero>){
        this.mHeroList.clear()

        this.mHeroList.addAll(arrayHeroes)

        notifyDataSetChanged()
    }

    class HeroHolder(v: View) : RecyclerView.ViewHolder(v){

        private var view: View = v

        fun bindHero(hero: Hero, position: Int){

            val imagePath: String = hero.thumbnail.path + "." + hero.thumbnail.extension

            Picasso.get()
                .load(imagePath)
                .placeholder(R.color.colorAccent)
                .into(this.view.imageViewHeroList)
        }
    }
}