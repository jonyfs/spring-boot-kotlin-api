package br.com.jonyfs.springbootkotlinapi.privilege

import br.com.jonyfs.springbootkotlinapi.model.NamedEntity
import br.com.jonyfs.springbootkotlinapi.role.Role
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.ManyToMany


/**
 * Created by jony on 25/05/17.
 */
@Entity
class Privilege : NamedEntity() {

    @ManyToMany(mappedBy = "privileges", cascade = arrayOf(CascadeType.ALL))
    var roles: Collection<Role>? = null

}