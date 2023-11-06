package com.zerobase.api.product.controller

import com.zerobase.api.product.dto.GetProducts
import com.zerobase.api.product.dto.ReceiveProductInfo
import com.zerobase.api.product.service.ProductService
import com.zerobase.domain.type.OrganizationCode
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Api(tags = ["product-information-controller-impl"], description = "상품 정보 API")
@RestController
@RequestMapping("/fintech/api/v1/product")
class ProductController(
    private val productService: ProductService
) {

    @ApiOperation(
        value = "상품 정보 조회 API",
        notes = "상품 정보를 조회하는 API"
    )
    @GetMapping("{organizationCode}")
    fun getProductInfos(
        @PathVariable organizationCode: OrganizationCode
    ): ResponseEntity<GetProducts.ResponseDto> =
        ResponseEntity.ok(productService.getProductInfosByOrganizationCode(organizationCode))

    @ApiOperation(
        value = "상품 정보 수신 API",
        notes = "금융사로부터 상품 정보를 받는 API"
    )
    @PostMapping("information")
    fun receiveProductInfo(
        @RequestBody productInfoRequestDto: ReceiveProductInfo.RequestDto
    ): ResponseEntity<ReceiveProductInfo.ResponseDto> =
        ResponseEntity.ok(productService.receiveProductInfo(productInfoRequestDto))
}