package hr.ferit.up404.laughly.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import hr.ferit.up404.laughly.R
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import kotlinx.coroutines.launch

data class Joke(
    val setup: String,
    val punchline: String
)

class ApiService constructor() {

    private val client = HttpClient(Android) {
        install(DefaultRequest) {
            headers.append("Content-Type", "application/json")
        }
        install(ContentNegotiation) {
            gson{

            }
        }
        engine {
            connectTimeout = 100_000
            socketTimeout = 100_000
        }
    }

    suspend fun getJoke(): Joke {
        return client.get("https://official-joke-api.appspot.com/random_joke").body()
    }
}

@Composable
fun LaughScreen(navController: NavHostController) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.cream))
            .padding(dimensionResource(id = R.dimen.padding_medium))
    ) {
        val coroutineScope = rememberCoroutineScope()
        var joke by remember {
            mutableStateOf(
                Joke(
                    "Two guys walk into a bar . . .",
                    "The first guy says \"Ouch!\" and the second says \"Yeah, I didn't see it either.\""
                )
            )
        }
        Text(
            text = joke.setup,
            fontSize = 32.sp,
            textAlign = TextAlign.Center
        )
        Text(
            text = joke.punchline,
            fontSize = 32.sp,
            textAlign = TextAlign.Center
        )
        Button(onClick = {
            coroutineScope.launch {
                joke = ApiService().getJoke()
            }
        }) {
            Image(
                painterResource(id = android.R.drawable.ic_menu_more),
                contentDescription = "New joke icon",
                modifier = Modifier.size(20.dp)
            )
            Text(text = "Get new joke!", Modifier.padding(start = 10.dp))
        }
    }
}

@Preview
@Composable
fun LaughScreenPreview() {
    LaughScreen(rememberNavController())
}
