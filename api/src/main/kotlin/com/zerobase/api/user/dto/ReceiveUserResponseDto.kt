package com.zerobase.api.user.dto

import com.zerobase.api.type.ResponseCode

data class ReceiveUserResponseDto(
    val data: UserKeyDto,
    val responseCode: String,
    val responseMessage: String
) {
    companion object {
        fun of(responseCode: ResponseCode, userKey: String): ReceiveUserResponseDto =
            ReceiveUserResponseDto(
                data = UserKeyDto(userKey),
                responseCode = responseCode.code,
                responseMessage = responseCode.message
            )
    }
}