package pl.dkiszka.hrcompany.domain.shared


import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.MappedSuperclass


@MappedSuperclass
abstract class BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id: Long? = null
}

