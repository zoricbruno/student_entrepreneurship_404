package hr.ferit.up404.laughly.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import hr.ferit.up404.laughly.R
import hr.ferit.up404.laughly.ui.Screen
import hr.ferit.up404.laughly.ui.components.NavigateButton

@Composable
fun HomeScreen(
    navController: NavController
) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Background gradient image",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            NavigateButton(
                text = stringResource(id = R.string.label_inspire),
                onClick = { navController.navigate(Screen.Inspire.route) }
            )
            NavigateButton(
                text = stringResource(id = R.string.label_laugh),
                onClick = { navController.navigate(Screen.Laugh.route) }
            )
            NavigateButton(
                text = stringResource(id = R.string.label_play),
                onClick = { navController.navigate(Screen.Play.route) }
            )
        }
    }
}



@Composable
@Preview
fun HomeScreenPreview() {
    HomeScreen(rememberNavController())
}
