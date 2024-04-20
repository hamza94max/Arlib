package com.arlib.task.utils

import java.util.*

object Utils {

    fun getGreeting(): String {
        val calendar = Calendar.getInstance()
        val hourOfDay = calendar.get(Calendar.HOUR_OF_DAY)

        return when (hourOfDay) {
            in 6..11 -> "Good morning"
            in 12..16 -> "Good afternoon"
            in 17..19 -> "Good evening"
            else -> "Good night"
        }
    }
}