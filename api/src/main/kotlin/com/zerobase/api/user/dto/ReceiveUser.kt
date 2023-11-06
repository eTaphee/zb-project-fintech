package com.zerobase.api.user.dto

import com.zerobase.api.type.ResponseCode
import com.zerobase.domain.domain.UserInfo

class ReceiveUser {
    data class RequestDto(
        val userIncomeAmount: Long,
        val userName: String,
        var userRegistrationNumber: String
    ) {
        fun toEntity(userKey: String): UserInfo =
            UserInfo(
                userKey = userKey,
                userName = userName,
                userRegistrationNumber = userRegistrationNumber,
                userIncomeAmount = userIncomeAmount
            )
    }

    data class ResponseDto(
        val data: UserKeyDto,
        val responseCode: String,
        val responseMessage: String
    ) {
        companion object {
            fun of(responseCode: ResponseCode, userKey: String): ResponseDto =
                ResponseDto(
                    data = UserKeyDto(userKey),
                    responseCode = responseCode.code,
                    responseMessage = responseCode.message
                )
        }
    }

    data class UserKeyDto(
        val userKey: String
    )
}