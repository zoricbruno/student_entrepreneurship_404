package hr.ferit.up404.laughly.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import hr.ferit.up404.laughly.R
import hr.ferit.up404.laughly.ui.viewmodels.LaughViewModel

@Composable
fun LaughScreen(viewModel: LaughViewModel = viewModel()) {
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.cream))
            .padding(dimensionResource(id = R.dimen.padding_medium))
    ) {
        val joke by viewModel.joke.collectAsState()
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
        Button(onClick = { viewModel.updateJoke() }) {
            Image(
                painterResource(id = android.R.drawable.ic_menu_more),
                contentDescription = stringResource(R.string.description_joke_icon),
                modifier = Modifier.size(20.dp)
            )
            Text(
                text = stringResource(R.string.label_refresh_joke),
                Modifier.padding(start = 10.dp)
            )
        }
    }
}

@Preview
@Composable
fun LaughScreenPreview() {
    LaughScreen()
}
