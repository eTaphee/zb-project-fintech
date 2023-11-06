package com.zerobase.api.product.service

import com.zerobase.api.product.dto.GetProducts
import com.zerobase.api.product.dto.ProductInfoDto
import com.zerobase.api.product.dto.ReceiveProductInfo
import com.zerobase.api.type.ResponseCode.SUCCESS
import com.zerobase.domain.repository.ProductInfoRepository
import com.zerobase.domain.type.OrganizationCode
import com.zerobase.domain.type.ProductCode
import org.springframework.stereotype.Service
import kotlin.streams.toList

@Service
class ProductServiceImpl(
    private val productInfoRepository: ProductInfoRepository
) : ProductService {
    override fun getProductInfosByOrganizationCode(
        organizationCode: OrganizationCode
    ): GetProducts.ResponseDto {
        return GetProducts.ResponseDto.of(
            SUCCESS,
            productInfoRepository
                .findAllByOrganizationCode(organizationCode)
                .stream()
                .map(ProductInfoDto::fromEntity)
                .toList()
        )
    }

    override fun receiveProductInfo(
        requestDto: ReceiveProductInfo.RequestDto
    ): ReceiveProductInfo.ResponseDto {
        val productInfo =
            productInfoRepository.findByOrganizationCodeAndProductCode(
                OrganizationCode.ofCode(requestDto.organizationCode),
                ProductCode.ofCode(requestDto.productCode)
            )

        if (productInfo == null) {
            productInfoRepository.save(requestDto.toEntity())
        } else {
            productInfo.productName = requestDto.productName
            productInfo.productMaximumInterest = requestDto.productMaximumInterest
            productInfo.productMinimumInterest = requestDto.productMinimumInterest
            productInfoRepository.save(productInfo)
        }

        return ReceiveProductInfo.ResponseDto.from(SUCCESS)
    }
}