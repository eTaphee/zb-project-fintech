package com.zerobase.api.user.service

import com.zerobase.api.exception.CustomErrorCode.USER_NOT_FOUND
import com.zerobase.api.exception.CustomException
import com.zerobase.api.loan.GenerateKey
import com.zerobase.api.loan.encrypt.EncryptComponent
import com.zerobase.api.type.ResponseCode.SUCCESS
import com.zerobase.api.user.dto.GetUserInfo
import com.zerobase.api.user.dto.ReceiveUser
import com.zerobase.api.user.dto.UserInfoDto
import com.zerobase.domain.repository.UserInfoRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserServiceImpl(
    private val userInfoRepository: UserInfoRepository,
    private val generateKey: GenerateKey,
    private val encryptComponent: EncryptComponent,
) : UserService {

    @Transactional
    override fun receiveUserInfo(requestDto: ReceiveUser.RequestDto): ReceiveUser.ResponseDto {
        requestDto.userRegistrationNumber =
            encryptComponent.encryptString(requestDto.userRegistrationNumber)

        val userKey = generateKey.generateUserKey()

        userInfoRepository.save(requestDto.toEntity(userKey))

        return ReceiveUser.ResponseDto.of(SUCCESS, userKey)
    }

    @Transactional(readOnly = true)
    override fun getUserInfo(userKey: String): GetUserInfo.ResponseDto {
        val userInfo = userInfoRepository.findByUserKey(userKey)
            ?: throw CustomException(USER_NOT_FOUND)

        return GetUserInfo.ResponseDto.of(SUCCESS, UserInfoDto.fromEntity(userInfo))
    }
}