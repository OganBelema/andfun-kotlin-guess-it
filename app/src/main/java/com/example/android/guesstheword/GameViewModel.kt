package com.example.android.guesstheword

import androidx.lifecycle.ViewModel
import timber.log.Timber

/**
 * Created by Belema Ogan on 2019-08-17.
 */
class GameViewModel: ViewModel() {

    init {
        Timber.d("GameViewModel created")
    }

    override fun onCleared() {
        Timber.d("GameViewModel cleared")
        super.onCleared()
    }
}