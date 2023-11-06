package com.zerobase.api.user.service

import com.zerobase.api.exception.CustomErrorCode.USER_NOT_FOUND
import com.zerobase.api.exception.CustomException
import com.zerobase.api.loan.GenerateKey
import com.zerobase.api.loan.encrypt.EncryptComponent
import com.zerobase.api.type.ResponseCode.SUCCESS
import com.zerobase.api.user.dto.GetUserInfoResponseDto
import com.zerobase.api.user.dto.ReceiveUserRequestDto
import com.zerobase.api.user.dto.ReceiveUserResponseDto
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
    override fun receiveUserInfo(receiveUserRequestDto: ReceiveUserRequestDto): ReceiveUserResponseDto {
        receiveUserRequestDto.userRegistrationNumber =
            encryptComponent.encryptString(receiveUserRequestDto.userRegistrationNumber)

        val userKey = generateKey.generateUserKey()

        userInfoRepository.save(receiveUserRequestDto.toEntity(userKey))

        return ReceiveUserResponseDto.of(SUCCESS, userKey)
    }

    @Transactional(readOnly = true)
    override fun getUserInfo(userKey: String): GetUserInfoResponseDto {
        val userInfo = userInfoRepository.findByUserKey(userKey)
            ?: throw CustomException(USER_NOT_FOUND)

        return GetUserInfoResponseDto.of(SUCCESS, UserInfoDto.fromEntity(userInfo))
    }
}