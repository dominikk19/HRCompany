package pl.dkiszka.hrcompany.domain.shared

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Embeddable
import javax.persistence.MappedSuperclass

@Embeddable
@MappedSuperclass
data class EmployeeNumber(
    @Column(name = "EMPLOYEE_NUMBER", nullable = false)
    val uuid: UUID = UUID.randomUUID()
){
    constructor(number: String): this(UUID.fromString(number))

    override fun toString(): String {
        return uuid.toString()
    }
}