package pl.dkiszka.hrcompany.application.employee.query

import org.springframework.stereotype.Component
import pl.dkiszka.hrcompany.domain.employee.Employee
import pl.dkiszka.hrcompany.domain.employee.EmployeeQueryRepository
import pl.dkiszka.hrcompany.domain.shared.EmployeeNumber

@Component
private class GetEmployeeHandler(
    private val employeeQueryRepository: EmployeeQueryRepository
) : GetEmployee {
    override fun invoke(employeeNumber: EmployeeNumber): Employee {
        return employeeQueryRepository.getByEmployeeNumber(employeeNumber)
    }
}