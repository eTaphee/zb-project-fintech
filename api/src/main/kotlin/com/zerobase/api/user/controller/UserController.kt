package com.zerobase.api.user.controller

import com.zerobase.api.user.dto.UserInfo
import com.zerobase.api.user.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/fintech/api/v1/user")
class UserController(
    private val userService: UserService
) {
    @GetMapping("private-info/{userKey}")
    fun getUser(
        @PathVariable userKey: String
    ): ResponseEntity<UserInfo.ResponseDto> =
        ResponseEntity.ok(userService.getUserInfo(userKey))
}