package hr.ferit.up404.laughly.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hr.ferit.up404.laughly.laughing.Joke
import hr.ferit.up404.laughly.laughing.JokesApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class LaughViewModel : ViewModel() {
    private val apiService = JokesApiService()
    val joke = MutableStateFlow(Joke("", ""))

    init {
        updateJoke()
    }

    fun updateJoke() {
        viewModelScope.launch {
            joke.value = apiService.getJoke()
        }
    }
}
