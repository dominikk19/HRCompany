package pl.dkiszka.hrcompany

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TestContainersApplication

fun main(args: Array<String>) {
    runApplication<TestContainersApplication>(*args)
}
