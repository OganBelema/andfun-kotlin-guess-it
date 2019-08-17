package com.example.android.guesstheword

import android.app.Application
import timber.log.Timber

/**
 * Created by Belema Ogan on 2019-08-17.
 */
class GuessItApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}