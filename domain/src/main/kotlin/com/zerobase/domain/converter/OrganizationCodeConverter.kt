package com.zerobase.domain.converter

import com.zerobase.domain.type.OrganizationCode
import javax.persistence.AttributeConverter
import javax.persistence.Convert

@Convert
class OrganizationCodeConverter : AttributeConverter<OrganizationCode, String> {
    override fun convertToDatabaseColumn(organizationCode: OrganizationCode): String {
        return organizationCode.code
    }

    override fun convertToEntityAttribute(dbData: String?): OrganizationCode {
        return OrganizationCode.ofCode(dbData)
    }
}