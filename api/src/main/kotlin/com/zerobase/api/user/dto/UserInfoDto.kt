package com.zerobase.api.user.dto

import com.zerobase.domain.domain.UserInfo
import io.swagger.annotations.ApiModelProperty

data class UserInfoDto(
    @ApiModelProperty(name = "유저 키", example = "1234567890")
    val userKey: String,
    @ApiModelProperty(name = "유저 주민등록번호", example = "930101-1234567")
    val userRegistrationNumber: String
) {
    companion object {
        fun fromEntity(userInfo: UserInfo): UserInfoDto =
            UserInfoDto(
                userInfo.userKey,
                userInfo.userRegistrationNumber
            )
    }
}