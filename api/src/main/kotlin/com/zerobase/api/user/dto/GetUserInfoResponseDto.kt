package com.zerobase.api.user.dto

import com.zerobase.api.type.ResponseCode
import io.swagger.annotations.ApiModelProperty

data class GetUserInfoResponseDto(
    val data: UserInfoDto?,
    @ApiModelProperty(name = "응답 코드", example = "00")
    val responseCode: String,
    @ApiModelProperty(name = "응답 메시지", example = "success")
    val responseMessage: String
) {
    companion object {
        fun of(
            responseCode: ResponseCode,
            userInfo: UserInfoDto?
        ): GetUserInfoResponseDto =
            GetUserInfoResponseDto(
                data = userInfo,
                responseCode = responseCode.code,
                responseMessage = responseCode.message
            )
    }
}
