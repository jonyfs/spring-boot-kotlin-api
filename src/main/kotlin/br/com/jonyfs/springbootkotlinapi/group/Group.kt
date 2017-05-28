package br.com.jonyfs.springbootkotlinapi.group

import br.com.jonyfs.springbootkotlinapi.model.NamedEntity
import br.com.jonyfs.springbootkotlinapi.user.User
import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.ManyToMany
import javax.persistence.Table


/**
 * Created by jony on 25/05/17.
 */
@Entity
@Table(name = "people_group") // to evict user lacks privilege or object not found on hsqldb
class Group : NamedEntity() {

    @ManyToMany(mappedBy = "groups", cascade = arrayOf(CascadeType.ALL))
    var users: Collection<User>? = null

}