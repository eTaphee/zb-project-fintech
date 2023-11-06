package com.zerobase.api.product.dto

import com.zerobase.domain.domain.ProductInfo
import com.zerobase.domain.type.OrganizationCode
import com.zerobase.domain.type.ProductCode

data class ReceiveProductInfoRequestDto(
    val organizationCode: String,
    val productCode: String,
    val productMaximumInterest: Double,
    val productMinimumInterest: Double,
    val productName: String
) {
    fun toEntity(): ProductInfo =
        ProductInfo(
            organizationCode = OrganizationCode.ofCode(organizationCode),
            productCode = ProductCode.ofCode(productCode),
            productName = productName,
            productMaximumInterest = productMaximumInterest,
            productMinimumInterest = productMinimumInterest
        )
}