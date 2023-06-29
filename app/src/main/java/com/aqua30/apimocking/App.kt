package com.aqua30.apimocking

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

/**
 * @author saurabh
 */
@HiltAndroidApp
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
    }

    companion object {
        lateinit  var appContext: Context
    }
}