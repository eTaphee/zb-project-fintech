package com.zerobase.api.product.dto

import com.zerobase.api.type.ResponseCode
import com.zerobase.domain.domain.ProductInfo
import com.zerobase.domain.type.OrganizationCode
import com.zerobase.domain.type.ProductCode

class ReceiveProductInfo {
    data class RequestDto(
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

    data class ResponseDto(
        val responseCode: String,
        val responseMessage: String
    ) {
        companion object {
            fun from(
                responseCode: ResponseCode
            ): ResponseDto =
                ResponseDto(
                    responseCode = responseCode.code,
                    responseMessage = responseCode.message
                )
        }
    }
}

