package com.zerobase.api.product.service

import com.zerobase.api.product.dto.GetProducts
import com.zerobase.api.product.dto.ReceiveProductInfo
import com.zerobase.domain.type.OrganizationCode

interface ProductService {
    fun getProductInfosByOrganizationCode(organizationCode: OrganizationCode): GetProducts.ResponseDto

    fun receiveProductInfo(requestDto: ReceiveProductInfo.RequestDto): ReceiveProductInfo.ResponseDto
}