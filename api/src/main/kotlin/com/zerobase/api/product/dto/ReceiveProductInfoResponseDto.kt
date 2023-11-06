package com.zerobase.api.product.dto

import com.zerobase.api.type.ResponseCode

data class ReceiveProductInfoResponseDto(
    val responseCode: String,
    val responseMessage: String
) {
    companion object {
        fun from(
            responseCode: ResponseCode
        ): ReceiveProductInfoResponseDto =
            ReceiveProductInfoResponseDto(
                responseCode = responseCode.code,
                responseMessage = responseCode.message
            )
    }
}

