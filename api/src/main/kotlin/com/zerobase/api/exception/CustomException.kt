package com.zerobase.api.exception

class CustomException(val errorCode: CustomErrorCode) : RuntimeException()