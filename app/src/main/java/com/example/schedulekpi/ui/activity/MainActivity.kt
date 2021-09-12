package com.example.schedulekpi.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.schedulekpi.app.ScheduleApplication
import com.example.schedulekpi.repository.ScheduleRepository
import com.example.schedulekpi.ui.theme.ScheduleKpiTheme
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var scheduleRepository: ScheduleRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ScheduleApplication.instance.applicationComponent.inject(this)

        lifecycleScope.launchWhenCreated {
            println("start")
            scheduleRepository.updateSchedule("бс-92")
        }

        setContent {
            ScheduleKpiTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ScheduleKpiTheme {
        Greeting("Android")
    }
}