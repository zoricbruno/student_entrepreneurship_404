package hr.ferit.up404.laughly.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import androidx.lifecycle.viewmodel.compose.viewModel
import hr.ferit.up404.laughly.R
import hr.ferit.up404.laughly.ui.viewmodels.InspireViewModel

@Composable
fun InspireScreen(viewModel: InspireViewModel = viewModel()) {
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
                painter = painterResource(id = viewModel.image),
                contentDescription = stringResource(id = viewModel.name),
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(100.dp, 100.dp).clip(CircleShape)
            )
            Text(
                text = stringResource(viewModel.name),
                fontSize = 48.sp,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.rosewater),
                modifier = Modifier.fillMaxWidth()
            )
        }
        Text(
            text = stringResource(id = viewModel.info),
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
            var quoteResourceId by remember { mutableStateOf(viewModel.getQuote()) }
            Text(
                text = stringResource(id = quoteResourceId),
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                color = colorResource(id = R.color.hotpink),
                modifier = Modifier.fillMaxWidth()
            )
            Button(onClick = { quoteResourceId = viewModel.getQuote() }) {
                Text(text = stringResource(R.string.label_quote))
            }
        }
    }
}

@Preview
@Composable
fun InspireScreenPreview() {
    InspireScreen()
}
