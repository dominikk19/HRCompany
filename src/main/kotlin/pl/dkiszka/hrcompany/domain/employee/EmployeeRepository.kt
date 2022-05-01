package pl.dkiszka.hrcompany.domain.employee

import org.springframework.data.jpa.repository.JpaRepository
import pl.dkiszka.hrcompany.domain.shared.EmployeeNumber

interface EmployeeRepository: EmployeeQueryRepository, JpaRepository<Employee, Long>


interface EmployeeQueryRepository{
    fun getByEmployeeNumber(employeeNumber: EmployeeNumber): Employee
}