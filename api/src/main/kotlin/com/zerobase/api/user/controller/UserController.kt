package com.zerobase.api.user.controller

import com.zerobase.api.user.dto.GetUserInfoResponseDto
import com.zerobase.api.user.dto.ReceiveUserRequestDto
import com.zerobase.api.user.dto.ReceiveUserResponseDto
import com.zerobase.api.user.service.UserService
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@Api(tags = ["user-information-controller-impl"], description = "유저 정보 API")
@RestController
@RequestMapping("/fintech/api/v1/user")
class UserController(
    private val userService: UserService
) {
    @ApiOperation(
        value = "유저 정보 수신 API",
        notes = "유저 정보를 받는 API"
    )
    @PostMapping("information")
    fun receiveUserInfo(
        @RequestBody userInfoReceiveUserRequestDto: ReceiveUserRequestDto
    ): ResponseEntity<ReceiveUserResponseDto> =
        ResponseEntity.ok(userService.receiveUserInfo(userInfoReceiveUserRequestDto))

    @ApiOperation(
        value = "유저 정보 조회 API",
        notes = "유저 정보를 조회하는 API"
    )
    @GetMapping("private-info/{userKey}")
    fun getUserInfo(
        @PathVariable userKey: String
    ): ResponseEntity<GetUserInfoResponseDto> =
        ResponseEntity.ok(userService.getUserInfo(userKey))
}