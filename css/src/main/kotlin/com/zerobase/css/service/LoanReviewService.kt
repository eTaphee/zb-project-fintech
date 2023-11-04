package com.zerobase.css.service

import com.zerobase.css.dto.LoanRequestDto
import com.zerobase.css.dto.LoanResultDto
import org.springframework.stereotype.Service

@Service
class LoanReviewService {
    fun loanReview(
        loanRequestInputDto: LoanRequestDto.RequestInputDto
    ): LoanResultDto.ResponseDto {
        if (loanRequestInputDto.userIncomeAmount < 0) throw RuntimeException("Invalid userIncomeAmount Param")
        if (loanRequestInputDto.userIncomeAmount < 10000000) return LoanResultDto.ResponseDto(
            loanRequestInputDto.userKey,
            10000000,
            0.0
        )
        if (loanRequestInputDto.userIncomeAmount < 20000000) return LoanResultDto.ResponseDto(
            loanRequestInputDto.userKey,
            20000000,
            10.0
        )
        if (loanRequestInputDto.userIncomeAmount < 30000000) return LoanResultDto.ResponseDto(
            loanRequestInputDto.userKey,
            30000000,
            9.0
        )
        if (loanRequestInputDto.userIncomeAmount < 40000000) return LoanResultDto.ResponseDto(
            loanRequestInputDto.userKey,
            40000000,
            8.0
        )
        if (loanRequestInputDto.userIncomeAmount < 50000000) return LoanResultDto.ResponseDto(
            loanRequestInputDto.userKey,
            50000000,
            7.0
        )

        return LoanResultDto.ResponseDto(
            loanRequestInputDto.userKey,
            60000000,
            6.0
        )
    }
}