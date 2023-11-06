package com.zerobase.api.product.dto

import com.zerobase.api.type.ResponseCode

data class GetProductsResponseDto(
    val data: Array<ProductInfoDto>,
    val responseCode: String,
    val responseMessage: String
) {
    companion object {
        fun of(
            responseCode: ResponseCode,
            productInfoList: List<ProductInfoDto>
        ): GetProductsResponseDto =
            GetProductsResponseDto(
                data = productInfoList.toTypedArray(),
                responseCode = responseCode.code,
                responseMessage = responseCode.message
            )
    }
}
