package com.zerobase.domain.domain

import com.zerobase.domain.converter.OrganizationCodeConverter
import com.zerobase.domain.converter.ProductCodeConverter
import com.zerobase.domain.type.OrganizationCode
import com.zerobase.domain.type.ProductCode
import javax.persistence.*

@Entity
@Table(name = "PRODUCT_INFO")
class ProductInfo(

    @Convert(converter = OrganizationCodeConverter::class)
    @Column(name = "org_cd")
    val organizationCode: OrganizationCode,

    @Convert(converter = ProductCodeConverter::class)
    @Column(name = "prod_cd")
    val productCode: ProductCode,

    @Column(name = "prod_nm")
    var productName: String,

    @Column(name = "prod_max_intr")
    var productMaximumInterest: Double,

    @Column(name = "prod_min_intr")
    var productMinimumInterest: Double
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null
}