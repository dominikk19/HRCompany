package pl.dkiszka.hrcompany.api.employee

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.transaction.annotation.Transactional
import pl.dkiszka.hrcompany.BaseIT
import pl.dkiszka.hrcompany.domain.employee.Employee
import pl.dkiszka.hrcompany.domain.employee.EmployeeRepository

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@AutoConfigureMockMvc
class EmployeeEndpointTest extends BaseIT {

    @Autowired
    private MockMvc mockMvc

    @Autowired
    private EmployeeRepository employeeRepository

    @Autowired
    private ObjectMapper objectMapper

    private String firstname = "Jan"
    private String secondName = "Tomasz"
    private String lastname = "Kowalski"

    def "should create employee"() {
        given:
        def createEmployeeReq = new CreateEmployeeDto(firstname, secondName, lastname)

        when:
        def response = mockMvc.perform(MockMvcRequestBuilders.post("/ext-api/v1/employees", )
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(createEmployeeReq)))
                .andExpect(status().isOk())
                .andReturn()
                .response

        then:
        response.contentAsString != null
    }

    @Transactional
    def "should return employee by number"() {
        given:
        def createdEmployee = new Employee(firstname, secondName, lastname)
        def employee = employeeRepository.save(createdEmployee)

        when:
        def response = mockMvc.perform(MockMvcRequestBuilders.get("/ext-api/v1/employees/${employee.employeeNumber}"))
                .andExpect(status().isOk())
                .andReturn()
                .response

        then:
        response.contentAsString != null
        def getEmployeeDto = objectMapper.readValue(response.contentAsString, GetEmployeeDto.class)
        getEmployeeDto.employeeNumber == employee.employeeNumber.toString()
    }

}
