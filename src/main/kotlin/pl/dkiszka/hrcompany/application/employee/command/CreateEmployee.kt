package pl.dkiszka.hrcompany.application.employee.command

import pl.dkiszka.hrcompany.domain.shared.EmployeeNumber

interface CreateEmployee {
    operator fun invoke(command: CreateEmployeeCommand): EmployeeNumber
}

data class CreateEmployeeCommand(
    val firstname: String,
    val secondName: String?,
    val lastname: String,
)