package com.example.schedulekpi.feature_schedule.presentation.search_schedule.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.schedulekpi.feature_schedule.domain.model.Group


@ExperimentalMaterialApi
@Composable
fun SearchItemView(
    modifier: Modifier = Modifier,
    group: Group,
    color: Color = Color.White,
    onSelect: (String) -> Unit
) {
    Surface(
        modifier = modifier,
        color = color,
        onClick = {
            onSelect(group.fullName)
        }
    ) {
        Text(
            text = group.fullName,
            fontSize = 16.sp,
            style = MaterialTheme.typography.body2,
            color = Color.Gray,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp),
            color = Color.Gray
        )
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun SearchItemViewPreview() {
    SearchItemView(
        modifier = Modifier.fillMaxWidth(),
        group = Group(id = 1, fullName = "БС-92", "БС", "http")
    ) {}
}