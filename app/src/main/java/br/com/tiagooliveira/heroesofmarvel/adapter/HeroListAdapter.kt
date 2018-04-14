package br.com.tiagooliveira.heroesofmarvel.adapter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import br.com.tiagooliveira.heroesofmarvel.R
import br.com.tiagooliveira.heroesofmarvel.activity.HeroDetailsActivity
import br.com.tiagooliveira.heroesofmarvel.model.Hero
import br.com.tiagooliveira.heroesofmarvel.utils.Utils
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

        holder.bindHero(hero, position, mContext)

    }

    fun setHeroesList(arrayHeroes: ArrayList<Hero>){
        this.mHeroList.clear()

        this.mHeroList.addAll(arrayHeroes)

        notifyDataSetChanged()
    }

    class HeroHolder(v: View) : RecyclerView.ViewHolder(v), View.OnClickListener{

        private var view: View = v
        var mHero: Hero? = null
        var mContext: Context? = null

        fun bindHero(hero: Hero, position: Int, context: Context){
            mContext = context
            mHero = hero

            val imagePath: String = hero.thumbnail.path + "." + hero.thumbnail.extension

            this.view.imageViewHeroList.setOnClickListener(this)

            Picasso.get()
                .load(imagePath)
                .placeholder(R.color.colorAccent)
                .into(this.view.imageViewHeroList)
        }

        override fun onClick(v: View?) {
            //TODO : Enviar para a tela de detalhes

            Log.d("TESTE", "CLICOU NO : " + mHero?.id)

            var intent: Intent = Intent(mContext, HeroDetailsActivity::class.java)

            var bundle: Bundle = Bundle()

            bundle.putSerializable(Utils.heroCode, mHero)

            intent.putExtras(bundle)

            mContext?.startActivity(intent)
        }
    }
}