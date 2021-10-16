package com.example.schedulekpi.feature_schedule.presentation.search_schedule.components

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.schedulekpi.ui.theme.ScheduleKpiTheme

@Composable
fun SearchTopAppBar() {

    TopAppBar(
        backgroundColor = MaterialTheme.colors.primarySurface,
        title = {
            Text(text = "KPI Schedule")
        }
    )
}

//@Preview
//@Composable
//fun SearchTopAppBarPreview() {
//    ScheduleKpiTheme {
//        Scaffold(
//            topBar = { SearchTopAppBar() }
//        ) {
//
//        }
//    }
//}