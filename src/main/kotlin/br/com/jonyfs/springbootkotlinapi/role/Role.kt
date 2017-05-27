package br.com.jonyfs.springbootkotlinapi.role

import br.com.jonyfs.springbootkotlinapi.privilege.Privilege
import br.com.jonyfs.springbootkotlinapi.user.User
import org.hibernate.validator.constraints.NotEmpty
import java.io.Serializable
import javax.persistence.*


/**
 * Created by jony on 25/05/17.
 */
@Entity
class Role : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    var id: Long? = null

    @NotEmpty
    var name: String? = null

    @ManyToMany(mappedBy = "roles", cascade = arrayOf(CascadeType.ALL))
    var users: Collection<User>? = null

    @ManyToMany(cascade = arrayOf(CascadeType.ALL))
    @JoinTable(name = "roles_privileges",
            joinColumns = arrayOf(
                    JoinColumn(name = "role_id",
                            referencedColumnName = "id")),
            inverseJoinColumns = arrayOf(JoinColumn(name = "privilege_id",
                    referencedColumnName = "id")))
    var privileges: Collection<Privilege>? = null
}