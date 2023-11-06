package com.zerobase.domain.type

import java.util.*

enum class ProductCode(val code: String) {
    NONE("000"),
    PRODUCT_ONE("001"),
    PRODUCT_TWO("002");

    companion object {
        fun ofCode(code: String?): ProductCode {
            return Arrays.stream(ProductCode.values())
                .filter { it.code == code }
                .findAny()
                .orElseGet { NONE }
        }
    }
}