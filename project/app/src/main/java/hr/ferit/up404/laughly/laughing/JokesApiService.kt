package hr.ferit.up404.laughly.laughing

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.gson.*

class JokesApiService {

    private val client = HttpClient(Android) {
        install(DefaultRequest) {
            headers.append("Content-Type", "application/json")
        }
        install(ContentNegotiation) {
            gson {
                setPrettyPrinting()
            }
        }
        engine {
            connectTimeout = 60_000
            socketTimeout = 60_000
        }
    }

    suspend fun getJoke(): Joke {
        return client.get("https://official-joke-api.appspot.com/random_joke").body()
    }
}