package br.com.jonyfs.springbootkotlinapi.model

/**
 * Created by jony on 28/05/17.
 */
import br.com.jonyfs.springbootkotlinapi.user.User
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import java.io.Serializable
import java.util.*
import javax.persistence.*


@MappedSuperclass
@EntityListeners(org.springframework.data.jpa.domain.support.AuditingEntityListener::class)
abstract class AuditableEntity : Serializable {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long? = null

    @CreatedDate
    val createdDate: Date? = null

    @CreatedBy
    val createdBy: User? = null

    @LastModifiedDate
    val lastModifiedDate: Date? = null

    @LastModifiedBy
    val lastModifiedBy: User? = null
}