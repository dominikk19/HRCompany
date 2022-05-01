package pl.dkiszka.hrcompany.application.employee.query

import pl.dkiszka.hrcompany.domain.employee.Employee
import pl.dkiszka.hrcompany.domain.shared.EmployeeNumber

interface GetEmployee {
    operator fun invoke(employeeNumber: EmployeeNumber): Employee
}