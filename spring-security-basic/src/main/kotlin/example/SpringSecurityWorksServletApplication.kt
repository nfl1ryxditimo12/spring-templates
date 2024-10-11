package example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringSecurityWorksServletApplication

fun main(args: Array<String>) {
    runApplication<SpringSecurityWorksServletApplication>(*args)
}
