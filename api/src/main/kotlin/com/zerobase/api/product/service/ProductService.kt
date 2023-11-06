package com.zerobase.api.product.service

import com.zerobase.api.product.dto.GetProductsResponseDto
import com.zerobase.api.product.dto.ReceiveProductInfoRequestDto
import com.zerobase.api.product.dto.ReceiveProductInfoResponseDto
import com.zerobase.domain.type.OrganizationCode

interface ProductService {
    fun getProductInfosByOrganizationCode(organizationCode: OrganizationCode): GetProductsResponseDto

    fun receiveProductInfo(receiveProductInfoRequestDto: ReceiveProductInfoRequestDto): ReceiveProductInfoResponseDto
}