package com.zerobase.api.user.dto

import com.zerobase.api.type.ResponseCode

class GetUserInfo {
    data class ResponseDto(
        val data: UserInfoDto?,
        val responseCode: String,
        val responseMessage: String
    ) {
        companion object {
            fun of(
                responseCode: ResponseCode,
                userInfo: UserInfoDto?
            ): ResponseDto =
                ResponseDto(
                    data = userInfo,
                    responseCode = responseCode.code,
                    responseMessage = responseCode.message
                )
        }
    }
}