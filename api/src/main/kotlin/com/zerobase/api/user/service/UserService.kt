package com.zerobase.api.user.service

import com.zerobase.api.user.dto.UserInfo

interface UserService {
    fun getUserInfo(userKey: String): UserInfo.ResponseDto
}