package com.zerobase.api.user.dto

import io.swagger.annotations.ApiModelProperty

data class UserKeyDto(
    @ApiModelProperty(name = "유저 키", example = "1234567890")
    val userKey: String
)
