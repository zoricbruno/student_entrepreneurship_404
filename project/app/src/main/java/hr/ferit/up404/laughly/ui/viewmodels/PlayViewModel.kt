package hr.ferit.up404.laughly.ui.viewmodels

import android.content.Context
import android.content.pm.PackageManager
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.lifecycle.ViewModel
import hr.ferit.up404.laughly.Laughly
import kotlinx.coroutines.flow.MutableStateFlow
import kotlin.math.sqrt
import kotlin.random.Random

class PlayViewModel : ViewModel() {

    val numbers = MutableStateFlow(listOf(1, 1, 1, 1, 1, 1))
    private val context = Laughly.application
    private val sensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private val accelerationSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    private val accelerationThreshold = 12
    private val sensorEventListener = object : SensorEventListener {
        override fun onSensorChanged(event: SensorEvent?) {
            event?.let {
                val total = event.values.map { it * it }.sum()
                if (sqrt(total) > accelerationThreshold) {
                    randomize()
                }
            }
        }

        override fun onAccuracyChanged(p0: Sensor?, p1: Int) {}
    }

    init {
        if (context.packageManager.hasSystemFeature(PackageManager.FEATURE_SENSOR_ACCELEROMETER)) {
            accelerationSensor?.let {
                sensorManager.registerListener(
                    sensorEventListener,
                    accelerationSensor,
                    SensorManager.SENSOR_DELAY_UI
                )
            }
        }
    }

    fun randomize() {
        val rolled = mutableListOf<Int>()
        repeat(6) {
            rolled.add(Random.nextInt(1, 7))
        }
        numbers.value = rolled
    }
}
