package pl.dkiszka.hrcompany.api.employee

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import pl.dkiszka.hrcompany.application.employee.command.CreateEmployee
import pl.dkiszka.hrcompany.application.employee.query.GetEmployee
import pl.dkiszka.hrcompany.domain.employee.Employee
import pl.dkiszka.hrcompany.domain.shared.EmployeeNumber
import java.util.UUID

@RestController
@RequestMapping("/ext-api/v1/employees")
private class EmployeeEndpoint(
    private val createEmployee: CreateEmployee,
    private val getEmployee: GetEmployee
) {

    @PostMapping
    fun create(@RequestBody newEmployee: CreateEmployeeDto): UUID{
        return createEmployee(newEmployee.toCommand()).uuid
    }

    @GetMapping("/{employeeNumber}")
    fun getByEmployeeNumber(@PathVariable employeeNumber: String): GetEmployeeDto {
        return getEmployee(EmployeeNumber(employeeNumber)).toDto()
    }
}

private fun Employee.toDto() = GetEmployeeDto(employeeNumber.toString(), firstname, secondName, lastname)