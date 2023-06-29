package com.aqua30.apimocking

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aqua30.apimocking.domain.model.Joke
import com.aqua30.apimocking.domain.repository.JokesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException
import javax.inject.Inject

/**
 * @author saurabh
 */
@HiltViewModel
class JokeViewModel @Inject constructor(
    private val repository: JokesRepository
): ViewModel() {

    private val _jokeFlow = MutableStateFlow(Joke())
    val jokeFlow = _jokeFlow.asStateFlow()

    fun getJoke() {
        viewModelScope.launch {
            try {
                val joke = repository.joke()
                Log.e("Tag","$joke")
                _jokeFlow.value = joke
            } catch (e: IOException) {
                _jokeFlow.value = Joke(
                    setup = "There is an error",
                    punchline = "So handle it no!"
                )
            }
        }
    }
}