package shop.fevertime.backend.config

import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.web.servlet.invoke

@EnableWebSecurity
class WebSecurityConfig: WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http {
            headers {
                frameOptions { disable() }
            }
            csrf { disable() }
            authorizeRequests {
                authorize("/**", anonymous)
            }
        }
    }
}