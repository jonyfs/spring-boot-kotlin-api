package br.com.jonyfs.springbootkotlinapi

import br.com.jonyfs.springbootkotlinapi.group.Group
import br.com.jonyfs.springbootkotlinapi.privilege.Privilege
import br.com.jonyfs.springbootkotlinapi.role.Role
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

        var roleUser = Role()
        roleUser.name = "USER"
        roleUser.privileges = listOf(privilegeCanCreate, privilegeCanRead, privilegeCanUpdate)

        var roleTeacher = Role()
        roleTeacher.name = "TEACHER"
        roleTeacher.privileges = listOf(privilegeCanCreate, privilegeCanRead, privilegeCanUpdate)

        var groupStudents = Group()
        groupStudents.name = "Students"

        var groupTeachers = Group()
        groupTeachers.name = "Teachers"

        var groupMathematics = Group()
        groupMathematics.name = "Mathematics"

        var groupBiology = Group()
        groupBiology.name = "Biology"


        var user1 = User()
        user1.firstName = "John"
        user1.lastName = "Smith"
        user1.email = "john.smith@test.com"
        user1.password = "XPTO"
        user1.roles = (listOf(roleGuest))


        var user2 = User()
        user2.firstName = "Joseph"
        user2.lastName = "Smith"
        user2.email = "joseph.smith@test.com"
        user2.password = "XPTO"
        user2.roles = (listOf(roleUser))
        user2.groups = (listOf(groupBiology, groupMathematics, groupStudents))

        var user3 = User()
        user3.firstName = "Lucy"
        user3.lastName = "Santos"
        user3.email = "lucy.santos@test.com"
        user3.password = "XPTO"
        user3.roles = (listOf(roleTeacher))
        user3.groups = (listOf(groupBiology, groupTeachers))

        var user4 = User()
        user4.firstName = "Jony"
        user4.lastName = "Santos"
        user4.email = "jony.santos@test.com"
        user4.password = "XPTO"
        user4.roles = (listOf(roleAdmin, roleTeacher))
        user4.groups = (listOf(groupMathematics, groupTeachers))

        var userAdmin = User()
        userAdmin.firstName = "Admin"
        userAdmin.lastName = "Admin"
        userAdmin.email = "admin@test.com"
        userAdmin.password = "XPTO"
        userAdmin.roles = (listOf(roleAdmin))

        userRepository.saveAll(listOf(user1, user2, user3, user4, userAdmin))
    }

}