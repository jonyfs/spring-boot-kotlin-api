package br.com.jonyfs.springbootkotlinapi.user

import br.com.jonyfs.springbootkotlinapi.group.Group
import br.com.jonyfs.springbootkotlinapi.model.AuditableProjection
import br.com.jonyfs.springbootkotlinapi.role.Role
import org.springframework.beans.factory.annotation.Value
import org.springframework.data.rest.core.config.Projection

/**
 * Created by jony on 27/05/17.
 */

@Projection(name = "virtual", types = arrayOf(User::class))
interface UserProjection : AuditableProjection {

    fun getFirstName(): String

    fun getLastName(): String

    fun getEmail(): String

    fun getGroups(): Group

    fun getRoles(): Role

    @get:Value("#{target.firstName} #{target.lastName}")
    val fullName: String

}