package br.com.jonyfs.springbootkotlinapi.config

/**
 * Created by jony on 28/05/17.
 */
import br.com.jonyfs.springbootkotlinapi.user.User
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.domain.AuditorAware
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.security.core.context.SecurityContextHolder

/**

 * @author jony
 */
@EnableJpaAuditing
@Configuration
class AuditingConfig {

    @Bean
    fun createAuditorProvider(): AuditorAware<User> {
        return SecurityAuditor()
    }

    @Bean
    fun createAuditingListener(): AuditingEntityListener {
        return AuditingEntityListener()
    }

    class SecurityAuditor : AuditorAware<User> {

        override fun getCurrentAuditor(): User? {
            val auth = SecurityContextHolder.getContext().authentication
            if (auth != null) {
                if (auth.details is User) {
                    return auth.details as User
                }
            }
            return null
        }
    }

}