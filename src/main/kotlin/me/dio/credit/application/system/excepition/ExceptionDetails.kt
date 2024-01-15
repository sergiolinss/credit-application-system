package me.dio.credit.application.system.excepition

import java.time.LocalDateTime

data class ExceptionDetails(
    val title: String,
    val timestamp: LocalDateTime,
    val status: Int,
    val exception: String,
    val datails: MutableMap<String, String?>
)
