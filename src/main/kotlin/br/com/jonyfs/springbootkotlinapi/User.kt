package br.com.jonyfs.springbootkotlinapi.user

import br.com.jonyfs.springbootkotlinapi.role.Role
import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.validator.constraints.NotEmpty
import java.io.Serializable
import javax.persistence.*


/**
 * Created by jony on 25/05/17.
 */
@Entity
class User : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null

    @NotEmpty
    var firstName: String? = null

    @NotEmpty
    var lastName: String? = null

    @NotEmpty
    var email: String? = null

    @JsonIgnore
    @NotEmpty
    var password: String? = null

    var enabled: Boolean = false

    var tokenExpired: Boolean = false

    @ManyToMany(cascade = arrayOf(CascadeType.ALL))
    @JoinTable(name = "users_roles", joinColumns = arrayOf(JoinColumn(name = "user_id", referencedColumnName = "id")), inverseJoinColumns = arrayOf(JoinColumn(name = "role_id", referencedColumnName = "id")))
    var roles: Collection<Role>? = null
}
