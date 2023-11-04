package com.zerobase.api.loan.request

import com.zerobase.domain.domain.UserInfo
import com.zerobase.kafka.dto.LoanRequestDto

class UserInfoDto(
    private val userKey: String,
    private val userName: String,
    private val userRegistrationNumber: String,
    private val userIncomeAmount: Long
) {
    fun toEntity() =
        UserInfo(
            userKey,
            userName,
            userRegistrationNumber,
            userIncomeAmount
        )

    fun toLoanRequestKafkaDto() =
        LoanRequestDto(
            userKey,
            userName,
            userRegistrationNumber,
            userIncomeAmount
        )
}