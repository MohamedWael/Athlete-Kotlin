package com.example.mohamed.joke.module.home.view

import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v4.app.FragmentManager
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.mohamed.joke.R
import com.example.mohamed.joke.module.home.pojo.Athlete
import android.widget.TextView
import com.example.mohamed.joke.applevel.utils.GlideApp


class DetailsFragment : BottomSheetDialogFragment() {

    /** Android Views  */
    lateinit var ivImage: ImageView
    lateinit var tvTitle: TextView
    lateinit var tvDescription: TextView

    /** Android Views **/


    companion object {

        private const val ATHLETE_ITEM = "athlete"
        fun newInstance(athelet: Athlete): DetailsFragment {
            val instance = DetailsFragment()
            val extras: Bundle = Bundle()
            extras.putSerializable(ATHLETE_ITEM, athelet)
            instance.arguments = extras
            return instance
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_details, container, false)
        bindViews(view)
        if (arguments != null) {
            val athlete: Athlete = arguments?.getSerializable(ATHLETE_ITEM) as Athlete
            updateView(athlete)
        }
        return view
    }

    private fun bindViews(rootView: View) {
        ivImage = rootView.findViewById<ImageView>(R.id.ivImage)
        tvTitle = rootView.findViewById(R.id.tvTitle)
        tvDescription = rootView.findViewById(R.id.tvDescription)
    }

    private fun updateView(athlete: Athlete) {
        tvTitle.text = athlete.name
        tvDescription.text = athlete.brief

        ivImage.visibility = if (!TextUtils.isEmpty(athlete.image)) View.VISIBLE else View.GONE
        GlideApp.with(ivImage).load(athlete.image).into(ivImage)

    }

    public fun show(manager: FragmentManager) {
        DetailsFragment.javaClass
        show(manager, this.javaClass.simpleName)
    }


}