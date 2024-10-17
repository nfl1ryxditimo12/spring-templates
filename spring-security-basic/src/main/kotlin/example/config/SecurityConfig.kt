package example.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {
    @Bean
    fun userDetailService(): UserDetailsService {
        val user: User.UserBuilder = User.builder().passwordEncoder { "{noop}$it" }
        val manager = InMemoryUserDetailsManager()
        manager.createUser(
            user
                .username("user")
                .password("password")
                .roles("USER")
                .build(),
        )
        manager.createUser(
            user
                .username("admin")
                .password("password")
                .roles("USER", "ADMIN")
                .build(),
        )
        return manager
    }

    @Bean
    @Order(1)
    fun adminFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.securityMatcher("/admin/**")
        http.authorizeHttpRequests { it.anyRequest().hasRole("ADMIN") }
        http.httpBasic { }

        return http.build()
    }

    @Bean
    fun defaultFilterChain(http: HttpSecurity): SecurityFilterChain {
        http.authorizeHttpRequests { it.anyRequest().authenticated() }
        http.formLogin { }

        return http.build()
    }
}
