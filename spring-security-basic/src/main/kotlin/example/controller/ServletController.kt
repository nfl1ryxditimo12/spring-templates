package example.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/")
class ServletController {
    @GetMapping("/admin")
    fun admin(): String = "Hello Admin!"

    @GetMapping("/user")
    fun user(): String = "Hello User!"
}
