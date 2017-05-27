package br.com.jonyfs.springbootkotlinapi.group

import br.com.jonyfs.springbootkotlinapi.user.User
import org.hibernate.validator.constraints.NotEmpty
import java.io.Serializable
import javax.persistence.*


/**
 * Created by jony on 25/05/17.
 */
@Entity
@Table(name = "people_group") // to evict user lacks privilege or object not found on hsqldb
class Group : Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    var id: Long? = null

    @NotEmpty
    var name: String? = null

    @ManyToMany(mappedBy = "groups", cascade = arrayOf(CascadeType.ALL))
    var users: Collection<User>? = null


}