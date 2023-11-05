package com.zerobase.api.loan.review

import com.zerobase.domain.domain.LoanReview

class LoanReviewDto {
    data class LoanReviewResponseDto(
        val userKey: String,
        val loanResult: LoanResult
    )

    data class LoanResult(
        val userLimitAmount: Long,
        val userLoanInterest: Double
    ) {
        companion object {
            fun fromEntity(loanReview: LoanReview): LoanResult =
                LoanResult(
                    loanReview.loanLimitedAmount,
                    loanReview.loanInterest
                )
        }
    }
}