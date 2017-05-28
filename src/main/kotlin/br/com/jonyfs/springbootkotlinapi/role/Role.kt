package br.com.jonyfs.springbootkotlinapi.role

import br.com.jonyfs.springbootkotlinapi.model.NamedEntity
import br.com.jonyfs.springbootkotlinapi.privilege.Privilege
import br.com.jonyfs.springbootkotlinapi.user.User
import javax.persistence.*


/**
 * Created by jony on 25/05/17.
 */
@Entity
class Role : NamedEntity() {

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