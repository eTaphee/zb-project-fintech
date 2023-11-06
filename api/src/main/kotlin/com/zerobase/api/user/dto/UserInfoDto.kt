package com.zerobase.api.user.dto

import com.zerobase.domain.domain.UserInfo

data class UserInfoDto(
    val userKey: String,
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