package com.zerobase.api.user.service

import com.zerobase.api.user.dto.GetUserInfoResponseDto
import com.zerobase.api.user.dto.ReceiveUserRequestDto
import com.zerobase.api.user.dto.ReceiveUserResponseDto

interface UserService {
    fun receiveUserInfo(receiveUserRequestDto: ReceiveUserRequestDto): ReceiveUserResponseDto
    fun getUserInfo(userKey: String): GetUserInfoResponseDto
}