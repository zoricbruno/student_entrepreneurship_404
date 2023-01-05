package hr.ferit.up404.laughly.quotes

object QuoteGenerator {
    val quotes = listOf<String>(
        "Sometimes it is the people no one imagines anything of who do the things that no one can imagine.",
        "A computer would deserve to be called intelligent if it could deceive a human into believing that it was human.",
        "Unless in communicating with it one says exactly what one means, trouble is bound to result."
    )

    fun nextQuote(): String {
        return quotes.random()
    }
}
