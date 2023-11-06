package com.zerobase.api.user.service

import com.zerobase.api.exception.CustomErrorCode.USER_NOT_FOUND
import com.zerobase.api.exception.CustomException
import com.zerobase.api.type.ResponseCode
import com.zerobase.api.user.dto.UserInfo
import com.zerobase.api.user.dto.UserInfoDto
import com.zerobase.domain.repository.UserInfoRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserServiceImpl(
    private val userInfoRepository: UserInfoRepository
) : UserService {
    @Transactional(readOnly = true)
    override fun getUserInfo(userKey: String): UserInfo.ResponseDto {
        val userInfo = userInfoRepository.findByUserKey(userKey)
            ?: throw CustomException(USER_NOT_FOUND)

        return UserInfo.ResponseDto.of(ResponseCode.SUCCESS, UserInfoDto.fromEntity(userInfo))
    }
}