package com.zerobase.api.product.dto

import com.zerobase.domain.domain.ProductInfo

data class ProductInfoDto(
    val organizationCode: String,
    val productCode: String,
    val productMaximumInterest: Double,
    val productMinimumInterest: Double,
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