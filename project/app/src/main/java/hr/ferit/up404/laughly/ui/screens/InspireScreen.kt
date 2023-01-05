package hr.ferit.up404.laughly.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import hr.ferit.up404.laughly.R
import hr.ferit.up404.laughly.quotes.QuoteGenerator

@Composable
fun InspireScreen(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(colorResource(id = R.color.cream))
            .padding(dimensionResource(id = R.dimen.padding_medium))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.weight(1f)
        ) {
            Image(
                painter = painterResource(id = R.drawable.turing),
                contentDescription = stringResource(id = R.string.name_turing),
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(100.dp, 100.dp).clip(CircleShape)
            )
            Text(
                text = stringResource(R.string.name_turing),
                fontSize = 48.sp,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.rosewater),
                modifier = Modifier.fillMaxWidth()
            )
        }
        Text(
            text = stringResource(id = R.string.info_turing),
            fontSize = 14.sp,
            modifier = Modifier
                .weight(3f)
                .fillMaxWidth()
                .padding(dimensionResource(id = R.dimen.padding_medium))
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.weight(1f)
        ) {
            var quote by remember { mutableStateOf(QuoteGenerator.nextQuote()) }
            Text(
                text = quote,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.hotpink),
                modifier = Modifier.fillMaxWidth()
            )
            Button(onClick = { quote = QuoteGenerator.nextQuote() }) {
                Text(text = stringResource(R.string.label_quote))
            }
        }
    }
}

@Preview
@Composable
fun InspireScreenPreview() {
    InspireScreen(rememberNavController())
}
