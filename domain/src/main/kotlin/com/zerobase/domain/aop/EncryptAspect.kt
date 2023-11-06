package com.zerobase.domain.aop

import com.zerobase.domain.encrypt.EncryptComponent
import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.springframework.stereotype.Component
import kotlin.reflect.KClass
import kotlin.reflect.KMutableProperty
import kotlin.reflect.KProperty1
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.findAnnotation

@Aspect
@Component
class EncryptAspect(
    private val encryptComponent: EncryptComponent
) {

    @Pointcut("execution(* org.springframework.data.jpa.repository.JpaRepository.save(..)) && args(entity)")
    fun savePointcut(entity: Any?) {
    }

    @Before("savePointcut(entity)", argNames = "entity")
    fun beforeSave(entity: Any?) {
        encryptFields(entity, getEncryptFields(entity!!::class));
    }

    @Pointcut("execution(* org.springframework.data.jpa.repository.JpaRepository+.find*(..))")
    fun findPointcut() {

    }

    @AfterReturning("findPointcut()", returning = "result")
    fun afterFind(result: Any?) {
        if (result is List<*>) {
            for (entity in result) {
                decryptFields(entity, getEncryptFields(entity!!::class));
            }
        } else {
            decryptFields(result, getEncryptFields(result!!::class));
        }
    }

    private fun getEncryptFields(kClass: KClass<out Any>) =
        kClass.declaredMemberProperties.filter { it.findAnnotation<Encrypt>() != null }

    private fun encryptFields(entity: Any?, encryptFields: List<KProperty1<out Any, *>>) {
        for (field in encryptFields) {
            val plainText = field.getter.call(entity).toString()
            (field as KMutableProperty<*>).setter.call(
                entity,
                encryptComponent.encryptString(plainText)
            )
        }
    }

    private fun decryptFields(entity: Any?, encryptFields: List<KProperty1<out Any, *>>) {
        for (field in encryptFields) {
            val cipherText = field.getter.call(entity).toString()
            (field as KMutableProperty<*>).setter.call(
                entity,
                encryptComponent.decryptString(cipherText)
            )
        }
    }
}