package com.example.mohamed.joke.module.home.view

import android.os.Bundle
import android.support.design.widget.BottomSheetDialogFragment
import android.support.v7.widget.LinearLayoutManager
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.ProgressBar
import com.example.mohamed.joke.R
import com.example.mohamed.joke.applevel.service.ResponseCallBack
import com.example.mohamed.joke.base.BaseActivity
import com.example.mohamed.joke.base.service.ErrorHandler
import com.example.mohamed.joke.module.home.adapter.AthleticsAdapter
import com.example.mohamed.joke.module.home.pojo.AtheleticsResponse
import com.example.mohamed.joke.module.home.service.AtheleticService
import retrofit2.Call
import retrofit2.Response

class MainActivity : BaseActivity() {

    /** Android Views  */
    lateinit var rvAthletics: android.support.v7.widget.RecyclerView
    lateinit var progress: ProgressBar

    /** Android Views **/


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
        rvAthletics.layoutManager = LinearLayoutManager(this)
        rvAthletics.adapter = AthleticsAdapter()

        setUpService()
    }

    private fun setUpService() {
        val service: AtheleticService = AtheleticService()

        showProgress(true)
        service.getAtheletics(object : ResponseCallBack<AtheleticsResponse> {
            override fun onSuccess(r: AtheleticsResponse?, response: Response<AtheleticsResponse>?) {
                showProgress(false)
                (rvAthletics.adapter as AthleticsAdapter).setItems(r?.athletes!!)
            }

            override fun onFailure(errorHandler: ErrorHandler?, call: Call<AtheleticsResponse>?) {
                showProgress(false)
                showErrorMsg(rvAthletics, errorHandler!!)
            }
        })
    }

    private fun bindViews() {
        rvAthletics = findViewById(R.id.rvAthletics)
        progress = findViewById(R.id.progress)
    }

    private fun showProgress(show: Boolean) {
        progress.visibility = if (show) VISIBLE else GONE
    }

}
