package com.zerobase.consumer.dto

import com.zerobase.domain.domain.LoanReview

data class ReviewResponseDto(
    val userKey: String,
    val limitAmount: Long,
    val interest: Double
) {
    fun toLoanReviewEntity() =
        LoanReview(
            userKey,
            limitAmount,
            interest
        )
}