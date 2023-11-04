package com.zerobase.api.exception

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.BAD_REQUEST

enum class CustomErrorCode(
    val statusCode: HttpStatus,
    val errorCode: String,
    val errorMessage: String
) {
    RESULT_NOT_FOUND(BAD_REQUEST, "E001", "result not found")
}