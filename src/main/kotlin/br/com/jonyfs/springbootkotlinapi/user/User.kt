package br.com.jonyfs.springbootkotlinapi.user

import br.com.jonyfs.springbootkotlinapi.group.Group
import br.com.jonyfs.springbootkotlinapi.role.Role
import br.com.jonyfs.springbootkotlinapi.util.BCryptPasswordDeserializer
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
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
    @Column(nullable = false, unique = true)
    var id: Long? = null

    @NotEmpty
    var firstName: String? = null

    @NotEmpty
    var lastName: String? = null

    @NotEmpty
    var email: String? = null

    @JsonDeserialize(using = BCryptPasswordDeserializer::class)
    @NotEmpty
    var password: String? = null

    var enabled: Boolean = false

    var tokenExpired: Boolean = false

    @ManyToMany(cascade = arrayOf(CascadeType.ALL))
    @JoinTable(name = "users_roles", joinColumns = arrayOf(JoinColumn(name = "user_id", referencedColumnName = "id")), inverseJoinColumns = arrayOf(JoinColumn(name = "role_id", referencedColumnName = "id")))
    var roles: Collection<Role>? = null

    @ManyToMany(cascade = arrayOf(CascadeType.ALL))
    @JoinTable(name = "users_groups", joinColumns = arrayOf(JoinColumn(name = "user_id", referencedColumnName = "id")), inverseJoinColumns = arrayOf(JoinColumn(name = "group_id", referencedColumnName = "id")))
    var groups: Collection<Group>? = null

}
