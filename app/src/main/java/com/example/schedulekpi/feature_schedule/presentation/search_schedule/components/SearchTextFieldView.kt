package com.example.schedulekpi.feature_schedule.presentation.search_schedule.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.schedulekpi.ui.theme.ScheduleKpiTheme

@Composable
fun SearchTextFieldView(
    modifier: Modifier = Modifier,
    textField: String,
    onValueChange: (String) -> Unit
) {
    val focusRequester = LocalFocusManager.current
    OutlinedTextField(
        modifier = modifier,
        value = textField,
        onValueChange = { onValueChange(it) },
        trailingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "search")
        },
        label = {
            Text(
                text = "Group",
                color = Color.Black,
                style = MaterialTheme.typography.body2,
                fontSize = 18.sp
            )
        },
        singleLine = true,
        keyboardActions = KeyboardActions(onDone = {focusRequester.clearFocus()})
    )
}

@Preview
@Composable
fun SearchTextFieldViewPreview() {
    ScheduleKpiTheme {
        androidx.compose.material.Surface(color = Color.Gray) {

            SearchTextFieldView(
                modifier = Modifier.fillMaxWidth(),
                ""
            ) { }
        }
    }
}