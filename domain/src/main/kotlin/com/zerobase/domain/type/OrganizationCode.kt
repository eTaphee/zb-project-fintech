package com.zerobase.domain.type

import java.util.*

enum class OrganizationCode(val code: String) {
    NONE("00000"),
    ORGANIZATION_ONE("00001"),
    ORGANIZATION_TWO("00002");

    companion object {
        fun ofCode(code: String?): OrganizationCode {
            return Arrays.stream(OrganizationCode.values())
                .filter { it.code == code }
                .findAny()
                .orElseGet { NONE }
        }
    }
}