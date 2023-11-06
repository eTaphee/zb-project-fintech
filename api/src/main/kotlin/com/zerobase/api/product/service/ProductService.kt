package com.zerobase.api.product.service

import com.zerobase.api.product.dto.GetProductsResponseDto
import com.zerobase.domain.type.OrganizationCode

interface ProductService {
    fun getProductInfosByOrganizationCode(organizationCode: OrganizationCode): GetProductsResponseDto
}