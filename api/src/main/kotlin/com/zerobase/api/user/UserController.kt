package com.zerobase.api.user

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/fintech/api/v1/user")
class UserController {
    @GetMapping("private-info/{userKey}")
    fun getUser(@PathVariable userKey: String) = ""
}