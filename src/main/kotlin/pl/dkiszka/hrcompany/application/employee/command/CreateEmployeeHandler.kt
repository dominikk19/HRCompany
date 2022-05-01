package pl.dkiszka.hrcompany.application.employee.command

import org.springframework.stereotype.Component
import pl.dkiszka.hrcompany.application.employee.command.EmployeeMapper.toDomain
import pl.dkiszka.hrcompany.domain.employee.Employee
import pl.dkiszka.hrcompany.domain.employee.EmployeeRepository
import pl.dkiszka.hrcompany.domain.shared.EmployeeNumber

@Component
private class CreateEmployeeHandler(
    private val employeeRepository: EmployeeRepository
): CreateEmployee {
    override fun invoke(command: CreateEmployeeCommand): EmployeeNumber {
        return employeeRepository.save(command.toDomain()).employeeNumber
    }
}

private object EmployeeMapper{

    fun CreateEmployeeCommand.toDomain(): Employee{
        return Employee(firstname, secondName, lastname)
    }
}