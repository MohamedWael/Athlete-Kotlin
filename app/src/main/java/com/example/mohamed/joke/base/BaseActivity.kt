package com.example.mohamed.joke.base

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.mohamed.joke.R
import com.example.mohamed.joke.base.service.ErrorHandler

open class BaseActivity : AppCompatActivity() {

    fun showErrorMsg(anchor: View, txt: String = "", txtRes: Int = 0) {
        var text = if (txtRes != 0) getString(txtRes) else txt

        val snackbar: Snackbar = Snackbar.make(anchor, text, Snackbar.LENGTH_LONG)
        snackbar.setAction(R.string.cancel, View.OnClickListener {
            if (snackbar.isShown) snackbar.dismiss()
        })
        snackbar.show()
    }

    fun showErrorMsg(view: View, errorHandler: ErrorHandler) {
        showErrorMsg(view, errorHandler.getString(), errorHandler.getStringRes())
    }

    public fun <T : AppCompatActivity> startActivityy(bundle: Bundle? = null, clazz: Class<T>, finish: Boolean = true) {
        val intent: Intent = Intent(this, clazz)
        if (bundle != null) {
            intent.putExtras(bundle)
        }
        startActivity(intent)
        if (finish) finish()
    }
}