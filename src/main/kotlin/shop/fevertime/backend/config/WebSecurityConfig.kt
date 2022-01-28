package shop.fevertime.backend.config

import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.web.servlet.invoke
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder


@EnableWebSecurity
class WebSecurityConfig : WebSecurityConfigurerAdapter(

) {

//    @Bean
//    override fun authenticationManagerBean(): AuthenticationManager? {
//        return super.authenticationManagerBean()
//    }

    @Bean
    fun encodePassword(): BCryptPasswordEncoder? {
        return BCryptPasswordEncoder()
    }

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