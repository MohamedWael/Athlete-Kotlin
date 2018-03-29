package com.example.mohamed.joke.module.home.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.mohamed.joke.module.home.pojo.Athlete
import com.example.mohamed.joke.module.home.wedgits.AthleticView

class AthleticsAdapter : RecyclerView.Adapter<AthleticsAdapter.AtheleticViewHolder>() {

    var athletes: MutableList<Athlete> = mutableListOf()

    public fun setItems(items: List<Athlete>) {
        athletes.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AtheleticViewHolder {
        val item: AthleticView = AthleticView(parent.context)
        return AtheleticViewHolder(item)
    }

    override fun getItemCount(): Int = athletes.size

    override fun onBindViewHolder(holder: AtheleticViewHolder, position: Int) {
        val athlete = athletes[position]
        (holder.itemView as AthleticView).setAthelitic(athlete)
    }

    class AtheleticViewHolder(itemView: AthleticView) : RecyclerView.ViewHolder(itemView)


}
