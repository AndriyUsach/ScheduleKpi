package com.example.schedulekpi.feature_schedule.presentation.splash.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.schedulekpi.R
import com.example.schedulekpi.ui.theme.ScheduleKpiTheme

@Composable
fun SplashLogoView(
    logoId: Int
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = logoId),
                contentDescription = "logo"
            )
        }
    }
}

@Preview
@Composable
fun SplashLogoViewPreview() {
    ScheduleKpiTheme {
        SplashLogoView(logoId = R.drawable.logo_color)
    }
}