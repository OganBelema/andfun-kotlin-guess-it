package com.example.android.guesstheword

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

/**
 * Created by Belema Ogan on 2019-08-17.
 */
class GameViewModel: ViewModel() {

    // The current word
    private val _word = MutableLiveData<String>()
    val word: LiveData<String>
        get() = _word


    // The current score
    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    //Game finish event
    private val _gameFinishedEvent = MutableLiveData<Boolean>()
    val gameFinishedEvent: LiveData<Boolean>
        get() = _gameFinishedEvent

    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>

    init {
        Timber.d("GameViewModel created")
        resetList()
        nextWord()
        _score.value = 0
        _gameFinishedEvent.value = false
    }

    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
                "queen",
                "hospital",
                "basketball",
                "cat",
                "change",
                "snail",
                "soup",
                "calendar",
                "sad",
                "desk",
                "guitar",
                "home",
                "railway",
                "zebra",
                "jelly",
                "car",
                "crow",
                "trade",
                "bag",
                "roll",
                "bubble"
        )
        wordList.shuffle()
    }

    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        //Select and remove a word from the list
        if (wordList.isEmpty()) {
            _gameFinishedEvent.value = true
        } else {
            _word.value = wordList.removeAt(0)
        }
    }

    /** Methods for buttons presses **/

    fun onSkip() {
        _score.value = score.value?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        _score.value = score.value?.plus(1)
        nextWord()
    }

    fun onGameFinishComplete(){
        _gameFinishedEvent.value = false
    }

    override fun onCleared() {
        Timber.d("GameViewModel cleared")
        super.onCleared()
    }
}