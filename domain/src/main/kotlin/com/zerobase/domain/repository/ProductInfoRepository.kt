package com.zerobase.domain.repository

import com.zerobase.domain.domain.ProductInfo
import com.zerobase.domain.type.OrganizationCode
import com.zerobase.domain.type.ProductCode
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductInfoRepository : JpaRepository<ProductInfo, Long> {
    fun findAllByOrganizationCode(organizationCode: OrganizationCode): List<ProductInfo>

    fun findByOrganizationCodeAndProductCode(
        organizationCode: OrganizationCode,
        productCode: ProductCode
    ): ProductInfo?
}