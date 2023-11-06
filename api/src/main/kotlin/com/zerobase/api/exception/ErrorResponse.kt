package com.zerobase.api.exception

import java.time.LocalDateTime

class ErrorResponse(
    private val customException: CustomException
) {
    data class ErrorResponseDto(
        val errorCode: String,
        val errorMessage: String
    ) {
        val timestamp: LocalDateTime = LocalDateTime.now()
    }
}