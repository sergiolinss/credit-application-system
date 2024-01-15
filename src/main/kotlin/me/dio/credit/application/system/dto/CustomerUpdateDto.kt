package me.dio.credit.application.system.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.entity.Customer
import org.aspectj.apache.bcel.classfile.Code
import java.math.BigDecimal

data class CustomerUpdateDto(
    @field:NotEmpty(message = "First name can not me null") val firstName: String,
    @field:NotEmpty(message = "Last name can not me null") val lastName: String,
    @field:NotNull(message = "Income can not be null") val income: BigDecimal,
    @field:NotEmpty(message = "zipCode can not me null") val zipCode: String,
    @field:NotEmpty(message = "Street") val street: String
) {
    fun toEntity(customer: Customer): Customer {
        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.street = street
        customer.address.zipCode = this.zipCode
        return customer
    }
}
