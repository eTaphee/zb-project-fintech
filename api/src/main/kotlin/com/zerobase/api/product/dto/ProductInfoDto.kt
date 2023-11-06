package com.zerobase.api.product.dto

import com.zerobase.domain.domain.ProductInfo
import io.swagger.annotations.ApiModelProperty

data class ProductInfoDto(
    @ApiModelProperty(name = "금융사 코드", example = "00001")
    val organizationCode: String,
    @ApiModelProperty(name = "상품 코드", example = "001")
    val productCode: String,
    @ApiModelProperty(name = "최대 이자", example = "9.9")
    val productMaximumInterest: Double,
    @ApiModelProperty(name = "최소 이자", example = "1.1")
    val productMinimumInterest: Double,
    @ApiModelProperty(name = "상품 이름", example = "상품1")
    val productName: String
) {
    companion object {
        fun fromEntity(productInfo: ProductInfo): ProductInfoDto =
            ProductInfoDto(
                productInfo.organizationCode.code,
                productInfo.productCode.code,
                productInfo.productMaximumInterest,
                productInfo.productMinimumInterest,
                productInfo.productName
            )
    }
}