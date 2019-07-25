package com.example.guestreservation

import android.app.Application
import android.content.Context
import com.example.guestreservation.DI.AppModule
import org.koin.android.ext.android.startKoin

class App: Application() {
    init {
        instance = this
    }

    companion object {
        private var instance: App? = null

        fun applicationContext(): Context {
            return instance!!.applicationContext
        }
    }

    override fun onCreate() {
        super.onCreate()
        val context: Context = App.applicationContext()
        startKoin(this, listOf(AppModule.appModule))
    }
}