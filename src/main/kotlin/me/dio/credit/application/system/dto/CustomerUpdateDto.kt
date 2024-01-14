package me.dio.credit.application.system.dto

import me.dio.credit.application.system.entity.Customer
import org.aspectj.apache.bcel.classfile.Code
import java.math.BigDecimal

data class CustomerUpdateDto(
    val firstName: String,
    val lastName: String,
    val income:BigDecimal,
    val zipCode:String,
    val street:String
) {
    fun toEntity(customer: Customer): Customer{
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.street = street
        customer.address.zipCode = this.zipCode
        return customer
    }
}
