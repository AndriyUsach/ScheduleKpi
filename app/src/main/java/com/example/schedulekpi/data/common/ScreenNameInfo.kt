package com.example.schedulekpi.data.common


data class ScreenName(val name: String)

enum class ScreenNameInfo(screenName: ScreenName) {
    SPLASH_SCREEN(ScreenName("splash_screen")),
    SCHEDULE_SCREEN(ScreenName("schedule_screen"))
}