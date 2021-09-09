package com.example.schedulekpi.utils

object UrlHelper {

    fun makeSearchParameter(prefix: String): String {
        return "{'query': '$prefix'}"
    }

}