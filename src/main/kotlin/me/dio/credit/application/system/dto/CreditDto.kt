package me.dio.credit.application.system.dto

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Max
import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import me.dio.credit.application.system.entity.Credit
import me.dio.credit.application.system.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field:NotNull(message = "Income can not be null") val creditValue: BigDecimal,
    val dayFirstOfInstallment: LocalDate,
    @field:Min(value = 1, message = "The minimum of installments is 1")
    @field:Max(value = 48, message = "The maximum of installments is 48")
    val numberOfInstallments: Int,
    @field:NotNull(message = "ID can not be null") val customerId: Long

) {
    init {
        validateDateOfFirstInstallments(dayFirstOfInstallment)
    }

    private fun validateDateOfFirstInstallments(date: LocalDate) {
        val MaximumDate = LocalDate.now().plusMonths(3)

        if (date.isAfter(MaximumDate)) {
            throw IllegalArgumentException("The date of the first installment must be at most 3 months from today")
        }

    }


fun toEntity(): Credit = Credit(
    creditValue = this.creditValue,
    dayFirstInstallment = this.dayFirstOfInstallment,
    numberOfInstallments = this.numberOfInstallments,
    customer = Customer(id = this.customerId)
)
}