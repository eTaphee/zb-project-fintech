package com.zerobase.api.user.dto

import com.zerobase.domain.domain.UserInfo

data class ReceiveUserRequestDto(
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