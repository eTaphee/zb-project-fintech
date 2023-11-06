package com.zerobase.api.product.service

import com.zerobase.api.product.dto.GetProductsResponseDto
import com.zerobase.api.product.dto.ProductInfoDto
import com.zerobase.api.type.ResponseCode.SUCCESS
import com.zerobase.domain.repository.ProductInfoRepository
import com.zerobase.domain.type.OrganizationCode
import org.springframework.stereotype.Service
import kotlin.streams.toList

@Service
class ProductServiceImpl(
    private val productInfoRepository: ProductInfoRepository
) : ProductService {
    override fun getProductInfosByOrganizationCode(
        organizationCode: OrganizationCode
    ): GetProductsResponseDto {
        return GetProductsResponseDto.of(
            SUCCESS,
            productInfoRepository
                .findAllByOrganizationCode(organizationCode)
                .stream()
                .map(ProductInfoDto::fromEntity)
                .toList()
        )
    }
}