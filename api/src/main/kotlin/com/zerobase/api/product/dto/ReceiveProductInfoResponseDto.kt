package com.zerobase.api.product.dto

import com.zerobase.api.type.ResponseCode
import io.swagger.annotations.ApiModelProperty

data class ReceiveProductInfoResponseDto(
    @ApiModelProperty(name = "응답 코드", example = "00")
    val responseCode: String,
    @ApiModelProperty(name = "응답 메시지", example = "success")
    val responseMessage: String
) {
    companion object {
        fun from(
            responseCode: ResponseCode
        ): ReceiveProductInfoResponseDto =
            ReceiveProductInfoResponseDto(
                responseCode = responseCode.code,
                responseMessage = responseCode.message
            )
    }
}

