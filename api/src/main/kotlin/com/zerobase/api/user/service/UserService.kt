package com.zerobase.api.user.service

import com.zerobase.api.user.dto.GetUserInfo
import com.zerobase.api.user.dto.ReceiveUser

interface UserService {
    fun receiveUserInfo(requestDto: ReceiveUser.RequestDto): ReceiveUser.ResponseDto
    fun getUserInfo(userKey: String): GetUserInfo.ResponseDto
}