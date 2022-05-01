package pl.dkiszka.hrcompany

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.spock.Testcontainers
import spock.lang.Shared
import spock.lang.Specification

@SpringBootTest
@ActiveProfiles("test")
@Testcontainers
abstract class BaseIT extends Specification {

    @Shared
    private PostgreSQLContainer<?> postgreContainser = new PostgreSQLContainer<>("postgres:14.2")
            .withDatabaseName("postgresDb")
            .withUsername("admin")
            .withPassword("admin")


    def setupSpec(){
        System.getProperties()
                .putAll([
                        "spring.datasource.url"     : postgreContainser.jdbcUrl,
                        "spring.datasource.username": postgreContainser.username,
                        "spring.datasource.password": postgreContainser.password
                ])
    }
}

