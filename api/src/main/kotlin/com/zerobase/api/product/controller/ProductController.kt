package com.zerobase.api.product.controller

import com.zerobase.api.product.dto.GetProductsResponseDto
import com.zerobase.api.product.service.ProductService
import com.zerobase.domain.type.OrganizationCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/fintech/api/v1/product")
class ProductController(
    private val productService: ProductService
) {

    @GetMapping("{organizationCode}")
    fun getProducts(
        @PathVariable organizationCode: OrganizationCode
    ): ResponseEntity<GetProductsResponseDto> =
        ResponseEntity.ok(productService.getProductInfosByOrganizationCode(organizationCode))

    @PostMapping("information")
    fun receiveProduct(@RequestBody aa: Any) = ""
}