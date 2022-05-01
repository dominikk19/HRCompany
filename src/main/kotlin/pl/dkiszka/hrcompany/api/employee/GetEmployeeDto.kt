package pl.dkiszka.hrcompany.api.employee

data class GetEmployeeDto(
    val employeeNumber: String,
    val firstname: String,
    val secondName: String? = null,
    val lastname: String
)