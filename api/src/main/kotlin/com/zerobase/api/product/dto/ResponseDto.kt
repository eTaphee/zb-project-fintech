package com.zerobase.api.product.dto

import com.zerobase.api.type.ResponseCode

class GetProducts {
    data class ResponseDto(
        val data: Array<ProductInfoDto>,
        val responseCode: String,
        val responseMessage: String
    ) {
        companion object {
            fun of(
                responseCode: ResponseCode,
                productInfoList: List<ProductInfoDto>
            ): ResponseDto =
                ResponseDto(
                    data = productInfoList.toTypedArray(),
                    responseCode = responseCode.code,
                    responseMessage = responseCode.message
                )
        }
    }
}