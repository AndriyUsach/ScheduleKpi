package com.example.schedulekpi.ui.activity

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.example.schedulekpi.api.ScheduleApi
import com.example.schedulekpi.app.ScheduleApplication
import com.example.schedulekpi.data.common.Constants
import com.example.schedulekpi.ui.theme.ScheduleKpiTheme
import com.example.schedulekpi.utils.UrlHelper
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var scheduleApi: ScheduleApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ScheduleApplication.instance.applicationComponent.inject(this)

        lifecycleScope.launchWhenCreated {
            val a = scheduleApi.getGroupTeachers("бс-92")
            Log.d("TAG", a.toString())
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