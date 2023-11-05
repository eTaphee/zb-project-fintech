package com.zerobase.api.loan.review

import com.zerobase.api.exception.CustomErrorCode.RESULT_NOT_FOUND
import com.zerobase.api.exception.CustomException
import com.zerobase.domain.domain.LoanReview
import com.zerobase.domain.repository.LoanReviewRepository
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class LoanReviewServiceImpl(
    private val loanReviewRepository: LoanReviewRepository,
) : LoanReviewService {

    @Cacheable(value = ["REVIEW"], key = "#userKey", cacheManager = "redisCacheManager")
    override fun loanReviewMain(userKey: String): LoanReviewDto.LoanReviewResponseDto {
        return LoanReviewDto.LoanReviewResponseDto(
            userKey = userKey,
            loanResult = getLoanResult(userKey)?.let { LoanReviewDto.LoanResult.fromEntity(it) }
                ?: throw CustomException(RESULT_NOT_FOUND)
        )
    }

    override fun getLoanResult(userKey: String): LoanReview? =
        loanReviewRepository.findByUserKey(userKey)
}