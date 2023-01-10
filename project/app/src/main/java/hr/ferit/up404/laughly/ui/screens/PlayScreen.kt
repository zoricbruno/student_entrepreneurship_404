package hr.ferit.up404.laughly.ui.screens

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import hr.ferit.up404.laughly.R
import kotlin.random.Random

@Composable
fun PlayScreen(navController: NavController) {
    var values by remember { mutableStateOf(listOf(1, 1, 1, 1, 1, 1)) }
    val sensorListener = object : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent?) {
            event?.let {
                val acceleration = event.values.map { it * it }.sum().toDouble()
                if (Math.sqrt(acceleration) > 11) {
                    values = randomize()
                }
            }
        }

        override fun onAccuracyChanged(p0: Sensor?, p1: Int) {}
    }

    val sensorManager =
        LocalContext.current.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    val accelerationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    sensorManager.registerListener(
        sensorListener,
        accelerationSensor,
        SensorManager.SENSOR_DELAY_UI
    )

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.cream))
            .padding(dimensionResource(id = R.dimen.padding_medium))
    ) {
        Dices(values)
        Button(onClick = { values = randomize() }) {
            Icon(imageVector = Icons.Default.Refresh, contentDescription = "Reroll")
            Text(text = "Re-roll")
        }
    }
}

fun randomize(): List<Int> {
    val numbers = mutableListOf<Int>()
    repeat(6) {
        numbers.add(Random.nextInt(1, 7))
    }
    return numbers
}

@Composable
fun Dices(values: List<Int>) {
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

@Preview
@Composable
fun PlayScreenPreview() {
    PlayScreen(rememberNavController())
}
