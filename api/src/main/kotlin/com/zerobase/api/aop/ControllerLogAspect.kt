package com.zerobase.api.aop

import mu.KotlinLogging
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.util.StopWatch
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import javax.servlet.http.HttpServletRequest


@Aspect
@Component
class ControllerLogAspect {
    private val logger = KotlinLogging.logger { }
    private val stopWatch = StopWatch()

    @Around("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    private fun postRequestLogging(joinPoint: ProceedingJoinPoint): Any {
        val request = getRequest()
        logger.info { "${request.method} ${request.requestURI} ${joinPoint.args[0]}" }

        val response = proceedJoinPointWithStopWatch(joinPoint)

        logger.info { "[${stopWatch.lastTaskTimeMillis} ms] ${response.statusCode} ${request.method} ${request.requestURL} ${response.body}" }

        return response
    }

    @Around("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private fun getRequestLogging(joinPoint: ProceedingJoinPoint): Any {
        val request = getRequest()
        logger.info { "${request.method} ${request.requestURI} ${request.queryString}" }

        val response = proceedJoinPointWithStopWatch(joinPoint)

        logger.info { "[${stopWatch.lastTaskTimeMillis} ms] ${response.statusCode} ${request.method} ${request.requestURL} ${response.body}" }

        return response
    }

    private fun proceedJoinPointWithStopWatch(
        joinPoint: ProceedingJoinPoint
    ): ResponseEntity<*> {
        stopWatch.start()
        val response = joinPoint.proceed() as ResponseEntity<*>
        stopWatch.stop()

        return response
    }

    private fun getRequest(): HttpServletRequest {
        val attributes = RequestContextHolder.getRequestAttributes() as ServletRequestAttributes?
        return attributes!!.request
    }
}