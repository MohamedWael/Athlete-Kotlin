package com.example.mohamed.joke.module.splashScreen

import android.os.Bundle
import android.os.Handler
import com.example.mohamed.joke.R
import com.example.mohamed.joke.applevel.AthleteConfig
import com.example.mohamed.joke.base.BaseActivity
import com.example.mohamed.joke.module.home.view.MainActivity

class SplashScreenActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        //why the .javaClass is not working in the MainActivity class and is working in DetailsFragment ?!
//        MainActivity.javaClass
//        DetailsFragment.javaClass
        Handler().postDelayed({ startActivityy(clazz = MainActivity::class.java) }, AthleteConfig.SPLASH_SCREEN_TIME_OUT)

    }

    // fun startMianActivity() = startActivityy(clazz = MainActivity::class.java)

}
