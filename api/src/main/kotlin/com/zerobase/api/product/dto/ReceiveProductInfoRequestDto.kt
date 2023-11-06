package com.zerobase.api.product.dto

import com.zerobase.domain.domain.ProductInfo
import com.zerobase.domain.type.OrganizationCode
import com.zerobase.domain.type.ProductCode
import io.swagger.annotations.ApiModelProperty

data class ReceiveProductInfoRequestDto(
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
    fun toEntity(): ProductInfo =
        ProductInfo(
            organizationCode = OrganizationCode.ofCode(organizationCode),
            productCode = ProductCode.ofCode(productCode),
            productName = productName,
            productMaximumInterest = productMaximumInterest,
            productMinimumInterest = productMinimumInterest
        )
}