package hr.ferit.up404.laughly.ui.viewmodels

import androidx.lifecycle.ViewModel
import hr.ferit.up404.laughly.R

class InspireViewModel : ViewModel() {

    val name = R.string.name_turing
    val info = R.string.info_turing
    val image = R.drawable.turing
    private val quotes = listOf<Int>(
        R.string.quote_turing_1,
        R.string.quote_turing_2,
        R.string.quote_turing_3
    )

    fun getQuote() = quotes.random()
}
