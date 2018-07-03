package br.com.jonyfs.springbootkotlinapi.config

/**
 * Created by jony on 28/05/17.
 */
import br.com.jonyfs.springbootkotlinapi.user.User
import java.util.Optional
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

        override fun getCurrentAuditor(): Optional<User>? {
            val auth = SecurityContextHolder.getContext().authentication
            if (auth == null) {
                return Optional.empty()
            } else {
                if (auth.details is User) {
                    return Optional.of(auth.details as User)
                }
                else{
                    return Optional.empty()
                }
            }

        }
    }

}