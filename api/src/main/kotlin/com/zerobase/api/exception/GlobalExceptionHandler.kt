package com.zerobase.api.exception

import com.fasterxml.jackson.module.kotlin.MissingKotlinParameterException
import com.zerobase.api.exception.CustomErrorCode.INTERNAL_ERROR
import com.zerobase.api.exception.CustomErrorCode.INVALID_REQUEST
import mu.KotlinLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {
    val logger = KotlinLogging.logger { }

    @ExceptionHandler(CustomException::class)
    private fun customExceptionHandler(
        exception: CustomException
    ): ResponseEntity<ErrorResponse.ErrorResponseDto> {
        logger.error { "$exception occurred" }
        return getErrorResponseEntity(exception.errorCode)
    }

    @ExceptionHandler(MissingKotlinParameterException::class)
    private fun missingParameterExceptionHandler(
        exception: MissingKotlinParameterException
    ): ResponseEntity<ErrorResponse.ErrorResponseDto> {
        logger.error { "$exception occurred" }
        return getErrorResponseEntity(INVALID_REQUEST)
    }

    @ExceptionHandler(Exception::class)
    private fun exceptionHandler(
        exception: Exception
    ): ResponseEntity<ErrorResponse.ErrorResponseDto> {
        logger.error { "$exception occurred" }
        return getErrorResponseEntity(INTERNAL_ERROR)
    }

    private fun getErrorResponseEntity(
        errorCode: CustomErrorCode
    ): ResponseEntity<ErrorResponse.ErrorResponseDto> {
        return ResponseEntity(
            ErrorResponse.ErrorResponseDto(
                errorCode.errorCode,
                errorCode.errorMessage
            ), errorCode.statusCode
        )
    }
}