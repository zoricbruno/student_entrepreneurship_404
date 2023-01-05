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

data class Joke(
    val setup: String,
    val punchline: String
)

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
        val joke by remember {
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
        Button(onClick = { }) {
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
