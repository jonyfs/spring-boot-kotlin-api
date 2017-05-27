package br.com.jonyfs.springbootkotlinapi.privilege

import br.com.jonyfs.springbootkotlinapi.role.Role
import org.hibernate.validator.constraints.NotEmpty
import java.io.Serializable
import javax.persistence.*


/**
 * Created by jony on 25/05/17.
 */
@Entity
class Privilege : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    var id: Long? = null

    @NotEmpty
    var name: String? = null

    @ManyToMany(mappedBy = "privileges", cascade = arrayOf(CascadeType.ALL))
    var roles: Collection<Role>? = null

}