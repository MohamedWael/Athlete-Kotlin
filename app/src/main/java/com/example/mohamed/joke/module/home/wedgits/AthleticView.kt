package com.example.mohamed.joke.module.home.wedgits

import android.content.Context
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.example.mohamed.joke.R
import com.example.mohamed.joke.module.home.pojo.Athlete
import retrofit2.Callback
import retrofit2.Response
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.mohamed.joke.applevel.utils.GlideApp
import com.example.mohamed.joke.module.home.view.DetailsFragment
import com.example.mohamed.joke.module.home.view.MainActivity


class AthleticView(context: Context) : LinearLayout(context) {
    private lateinit var athlete: Athlete

    /** Android Views  */
    private lateinit var ivImage: ImageView
    private lateinit var tvTitle: TextView
    private lateinit var tvDescription: TextView
    /** Android Views **/


    private var view: View? = null

    init {
        initView(context)
    }

    constructor(context: Context, attributeSet: AttributeSet) : this(context) {
        initView(context)
    }

    private fun initView(context: Context) {
        view = View.inflate(context, R.layout.view_athelitic, this)
        bindViews(view!!)
    }

    private fun bindViews(rootView: View) {
        ivImage = rootView.findViewById<ImageView>(R.id.ivImage)
        tvTitle = rootView.findViewById(R.id.tvTitle)
        tvDescription = rootView.findViewById(R.id.tvDescription)
    }

    fun setAthelitic(athlete: Athlete) {
        this.athlete = athlete

        tvTitle.text = athlete.name
        tvDescription.text = athlete.brief

        ivImage.visibility = if (!TextUtils.isEmpty(athlete.image)) View.VISIBLE else View.GONE
        GlideApp.with(ivImage).load(athlete.image).into(ivImage)

        setOnClickListener(OnClickListener {
            DetailsFragment.newInstance(athlete).show((it.context as MainActivity).supportFragmentManager)
        })
    }


}