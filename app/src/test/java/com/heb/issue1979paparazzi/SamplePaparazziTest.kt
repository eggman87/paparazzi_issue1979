package com.heb.issue1979paparazzi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class SamplePaparazziTest(private val inDarkMode: Boolean) {

    @get:Rule
    val paparazzi = Paparazzi(deviceConfig = DeviceConfig.PIXEL_6)

    @Test
    fun `sample paparazzi test`() {
        paparazzi.snapshot {
            Column(modifier = Modifier.background(Color.Red).fillMaxSize()) {
                Text("Hello there!")
            }
        }
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters(name = "darkMode={0}")
        fun data(): Collection<Any> {
            return listOf(true, false)
        }
    }
}