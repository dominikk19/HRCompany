package pl.dkiszka.hrcompany.domain.employee

import pl.dkiszka.hrcompany.domain.shared.BaseEntity
import pl.dkiszka.hrcompany.domain.shared.EmployeeNumber
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "EMPLOYEES")
class Employee(
    val firstname: String,
    val secondName: String?,
    val lastname: String
): BaseEntity(){

    @Embedded
    val employeeNumber: EmployeeNumber = EmployeeNumber()

}