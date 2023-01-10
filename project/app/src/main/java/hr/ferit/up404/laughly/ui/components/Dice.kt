package hr.ferit.up404.laughly.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import hr.ferit.up404.laughly.R

@Composable
fun Dice(values: List<Int>) {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = GetDiceDrawableId(values[0])),
                contentDescription = "Icon 1"
            )
            Image(
                painter = painterResource(id = GetDiceDrawableId(values[1])),
                contentDescription = "Icon 1"
            )
            Image(
                painter = painterResource(id = GetDiceDrawableId(values[2])),
                contentDescription = "Icon 1"
            )
        }
        Spacer(modifier = Modifier.size(16.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = GetDiceDrawableId(values[3])),
                contentDescription = "Icon 1"
            )
            Image(
                painter = painterResource(id = GetDiceDrawableId(values[4])),
                contentDescription = "Icon 1"
            )
            Image(
                painter = painterResource(id = GetDiceDrawableId(values[5])),
                contentDescription = "Icon 1"
            )
        }
    }
}

fun GetDiceDrawableId(value: Int): Int {
    return when (value) {
        1 -> R.drawable.d1
        2 -> R.drawable.d2
        3 -> R.drawable.d3
        4 -> R.drawable.d4
        5 -> R.drawable.d5
        6 -> R.drawable.d6
        else -> R.drawable.d1
    }
}