package example.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/")
class ServletController {
    @GetMapping("/hello")
    fun hello(): String = "hello world"

    @GetMapping("/authorized")
    fun authorized(): String = "Authorized!"
}
