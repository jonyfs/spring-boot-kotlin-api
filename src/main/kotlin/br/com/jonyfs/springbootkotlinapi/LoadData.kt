package br.com.jonyfs.springbootkotlinapi

import br.com.jonyfs.springbootkotlinapi.privilege.Privilege
import br.com.jonyfs.springbootkotlinapi.privilege.PrivilegeRepository
import br.com.jonyfs.springbootkotlinapi.role.Role
import br.com.jonyfs.springbootkotlinapi.role.RoleRepository
import br.com.jonyfs.springbootkotlinapi.user.User
import br.com.jonyfs.springbootkotlinapi.user.UserRepository
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct
import javax.annotation.Resource


/**
 * Created by jony on 25/05/17.
 */
@Component
class LoadData {

    @Resource
    lateinit var userRepository: UserRepository

    @Resource
    lateinit var roleRepository: RoleRepository

    @Resource
    lateinit var privilegeRepository: PrivilegeRepository

    @PostConstruct
    fun load() {

        var privilegeCanCreate = Privilege()

        privilegeCanCreate.name = "CREATE"

        var privilegeCanRead = Privilege()

        privilegeCanRead.name = "READ"

        var privilegeCanUpdate = Privilege()

        privilegeCanUpdate.name = "UPDATE"

        var privilegeCanDelete = Privilege()

        privilegeCanDelete.name = "DELETE"


        var roleAdmin = Role()

        roleAdmin.name = "ADMIN"
        roleAdmin.privileges = listOf(privilegeCanCreate, privilegeCanRead, privilegeCanUpdate, privilegeCanDelete)

        var roleGuest = Role()

        roleGuest.name = "GUEST"
        roleGuest.privileges = listOf(privilegeCanRead)


        var user = User()
        user.firstName = "John"
        user.lastName = "Smith"
        user.email = "john.smith@test.com"
        user.password = "XPTO"
        user.roles = (listOf(roleGuest))

        var userAdmin = User()
        userAdmin.firstName = "Admin"
        userAdmin.lastName = "Admin"
        userAdmin.email = "admin@test.com"
        userAdmin.password = "XPTO"
        user.roles = (listOf(roleAdmin))

        userRepository.saveAll(listOf(user, userAdmin))
    }

}