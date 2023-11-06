package com.zerobase.api.user.dto

import com.zerobase.api.type.ResponseCode

data class GetUserInfoResponseDto(
    val data: UserInfoDto?,
    val responseCode: String,
    val responseMessage: String
) {
    companion object {
        fun of(
            responseCode: ResponseCode,
            userInfo: UserInfoDto?
        ): GetUserInfoResponseDto =
            GetUserInfoResponseDto(
                data = userInfo,
                responseCode = responseCode.code,
                responseMessage = responseCode.message
            )
    }
}
