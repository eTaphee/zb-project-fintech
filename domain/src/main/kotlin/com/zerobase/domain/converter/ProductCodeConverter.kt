package com.zerobase.domain.converter

import com.zerobase.domain.type.OrganizationCode
import com.zerobase.domain.type.ProductCode
import javax.persistence.AttributeConverter
import javax.persistence.Convert

@Convert
class ProductCodeConverter  : AttributeConverter<ProductCode, String> {
    override fun convertToDatabaseColumn(productCode: ProductCode): String {
        return productCode.code
    }

    override fun convertToEntityAttribute(dbData: String?): ProductCode {
        return ProductCode.ofCode(dbData)
    }
}