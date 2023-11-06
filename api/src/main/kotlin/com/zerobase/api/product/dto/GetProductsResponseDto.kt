package com.zerobase.api.product.dto

import com.zerobase.api.type.ResponseCode
import io.swagger.annotations.ApiModelProperty

data class GetProductsResponseDto(
    val data: Array<ProductInfoDto>,
    @ApiModelProperty(name = "응답 코드", example = "00")
    val responseCode: String,
    @ApiModelProperty(name = "응답 메시지", example = "success")
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
