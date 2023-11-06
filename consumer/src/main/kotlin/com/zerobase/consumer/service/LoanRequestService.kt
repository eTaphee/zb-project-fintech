package com.zerobase.consumer.service

import com.zerobase.consumer.dto.ReviewResponseDto
import com.zerobase.domain.domain.LoanReview
import com.zerobase.domain.repository.LoanReviewRepository
import com.zerobase.kafka.dto.LoanRequestDto
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Service
import java.time.Duration
import javax.annotation.PostConstruct

@Service
class LoanRequestService(
    private val loanReviewRepository: LoanReviewRepository
) {
    @Value("\${css.url}")
    private lateinit var cssUrl: String
    private lateinit var requestUrl: String

    @PostConstruct
    private fun initialize() {
        requestUrl = "${cssUrl}/css/api/v1/request"
    }

    fun loanRequest(loanRequestDto: LoanRequestDto) {
        val reviewResult = loanRequestToCb(loanRequestDto)
        saveLoanReviewData(reviewResult.toLoanReviewEntity())
    }

    fun loanRequestToCb(loanRequestDto: LoanRequestDto): ReviewResponseDto {
        val restTemplate = RestTemplateBuilder()
            .setConnectTimeout(Duration.ofMillis(1000))
            .setReadTimeout(Duration.ofMillis(1000))
            .build()

        return restTemplate.postForEntity(
            requestUrl,
            loanRequestDto,
            ReviewResponseDto::class.java
        ).body!!
    }

    fun saveLoanReviewData(loanReview: LoanReview) = loanReviewRepository.save(loanReview)
}