package com.example.schedulekpi.feature_schedule.domain.util

object UrlHelper {

    fun makeSearchParameter(search: String): String {
        return "{'query': '$search'}"
    }
}