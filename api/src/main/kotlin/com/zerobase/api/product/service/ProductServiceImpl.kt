package com.zerobase.api.product.service

import com.zerobase.api.product.dto.GetProductsResponseDto
import com.zerobase.api.product.dto.ProductInfoDto
import com.zerobase.api.product.dto.ReceiveProductInfoRequestDto
import com.zerobase.api.product.dto.ReceiveProductInfoResponseDto
import com.zerobase.api.type.ResponseCode.SUCCESS
import com.zerobase.domain.repository.ProductInfoRepository
import com.zerobase.domain.type.OrganizationCode
import com.zerobase.domain.type.ProductCode
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.streams.toList

@Service
class ProductServiceImpl(
    private val productInfoRepository: ProductInfoRepository
) : ProductService {
    @Transactional(readOnly = true)
    @Cacheable(
        value = ["PRODUCT"],
        key = "#organizationCode.code",
        cacheManager = "redisCacheManager"
    )
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

    @Transactional
    @CacheEvict(value = ["PRODUCT"], key = "#receiveProductInfoRequestDto.organizationCode")
    override fun receiveProductInfo(
        receiveProductInfoRequestDto: ReceiveProductInfoRequestDto
    ): ReceiveProductInfoResponseDto {
        val productInfo =
            productInfoRepository.findByOrganizationCodeAndProductCode(
                OrganizationCode.ofCode(receiveProductInfoRequestDto.organizationCode),
                ProductCode.ofCode(receiveProductInfoRequestDto.productCode)
            )

        if (productInfo == null) {
            productInfoRepository.save(receiveProductInfoRequestDto.toEntity())
        } else {
            productInfo.productName = receiveProductInfoRequestDto.productName
            productInfo.productMaximumInterest = receiveProductInfoRequestDto.productMaximumInterest
            productInfo.productMinimumInterest = receiveProductInfoRequestDto.productMinimumInterest
            productInfoRepository.save(productInfo)
        }

        return ReceiveProductInfoResponseDto.from(SUCCESS)
    }
}