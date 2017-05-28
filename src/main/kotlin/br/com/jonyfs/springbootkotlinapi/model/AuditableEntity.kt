package br.com.jonyfs.springbootkotlinapi.model

/**
 * Created by jony on 28/05/17.
 */
import br.com.jonyfs.springbootkotlinapi.user.User
import org.springframework.data.jpa.domain.AbstractAuditable
import java.io.Serializable
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass


@MappedSuperclass
@EntityListeners(org.springframework.data.jpa.domain.support.AuditingEntityListener::class)
abstract class AuditableEntity<PK : Serializable> : AbstractAuditable<User, PK>()