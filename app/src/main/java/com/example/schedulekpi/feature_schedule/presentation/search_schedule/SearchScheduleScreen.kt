package com.example.schedulekpi.feature_schedule.presentation.search_schedule

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.schedulekpi.feature_schedule.presentation.search_schedule.components.SearchItemView
import com.example.schedulekpi.feature_schedule.presentation.search_schedule.components.SearchTextFieldView
import com.example.schedulekpi.feature_schedule.presentation.search_schedule.components.SearchTopAppBar
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalMaterialApi
@ExperimentalCoroutinesApi
@Composable
fun SearchScheduleScreen(
    navController: NavController,
    viewModel: SearchScheduleViewModel = hiltViewModel()
) {
    val searchState = viewModel.search
    val result = viewModel.result.collectAsState(initial = emptyList())

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            SearchTopAppBar()
        }
    ) {
        Column(
            modifier = Modifier.padding(top = 30.dp, start = 16.dp, end = 16.dp, bottom = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            SearchTextFieldView(
                modifier = Modifier.fillMaxWidth(),
                textField = searchState.value.text,
                onValueChange = {
                    viewModel.onEvent(
                        SearchScheduleEvent.UpdateSearch(text = it)
                    )
                }
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .animateContentSize()
                    .padding(start = 8.dp, end = 8.dp)
            ) {
                items(result.value) { group ->
                    SearchItemView(
                        group = group,
                        onSelect = {
                            viewModel.onEvent(
                                SearchScheduleEvent.SelectSchedule(text = it)
                            )
                        }
                    )
                }
                item {
                    Divider(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(1.dp)
                    )
                }
            }
        }
    }
}