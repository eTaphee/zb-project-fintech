package com.zerobase.api.user.dto

import com.zerobase.domain.domain.UserInfo
import io.swagger.annotations.ApiModelProperty

data class ReceiveUserRequestDto(
    @ApiModelProperty(name = "유저 수입", example = "100000")
    val userIncomeAmount: Long,
    @ApiModelProperty(name = "유저 이름", example = "백엔드")
    val userName: String,
    @ApiModelProperty(name = "유저 주민등록번호", example = "930101-1234567")
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