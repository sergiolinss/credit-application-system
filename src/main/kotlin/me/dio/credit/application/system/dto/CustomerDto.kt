package me.dio.credit.application.system.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.entity.Address
import me.dio.credit.application.system.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto (
    @field:NotEmpty(message = "First name can not me null") val firstName: String,
    @field:NotEmpty(message = "Last name can not me null")val lastName: String,
    @field:CPF(message = "CPF Invalid")val cpf: String,
    @field:NotNull(message = "Income can not be null")val income: BigDecimal,
    @field:NotEmpty(message = "E-Mail can not me null") val email: String,
    @field:NotEmpty(message = "Password can not me null")val password: String,
    @field:NotEmpty(message = "zipCode can not me null")val zipCode: String,
    @field:NotEmpty(message = "Street")val street: String,
    ){
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )


    )

}
