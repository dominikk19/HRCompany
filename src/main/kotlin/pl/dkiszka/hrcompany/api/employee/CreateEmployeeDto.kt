package pl.dkiszka.hrcompany.api.employee

import pl.dkiszka.hrcompany.application.employee.command.CreateEmployeeCommand

data class CreateEmployeeDto(
    val firstname: String,
    val secondName: String? = null,
    val lastname: String
) {
    fun toCommand(): CreateEmployeeCommand {
        return CreateEmployeeCommand(firstname, secondName, lastname)
    }
}