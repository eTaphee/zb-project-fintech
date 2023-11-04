package com.zerobase.api.loan.request

import com.zerobase.domain.domain.UserInfo

class UserInfoDto(
    private val userKey: String,
    private val userName: String,
    private val userRegistrationNumber: String,
    private val userIncomeAmount: Long
) {
    fun toEntity() : UserInfo =
        UserInfo(
            userKey,
            userName,
            userRegistrationNumber,
            userIncomeAmount
        )
}