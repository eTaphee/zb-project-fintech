package com.zerobase.api.exception

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR

enum class CustomErrorCode(
    val statusCode: HttpStatus,
    val errorCode: String,
    val errorMessage: String
) {
    INTERNAL_ERROR(INTERNAL_SERVER_ERROR, "E000", "internal error"),
    INVALID_REQUEST(BAD_REQUEST, "E001", "invalid request"),
    RESULT_NOT_FOUND(BAD_REQUEST, "E002", "result not found")
}