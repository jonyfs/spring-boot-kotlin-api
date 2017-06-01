package br.com.jonyfs.springbootkotlinapi.user

import org.springframework.beans.factory.annotation.Value
import org.springframework.data.rest.core.config.Projection

/**
 * Created by jony on 27/05/17.
 */

@Projection(name = "virtual", types = arrayOf(User::class))
interface UserProjection {

    fun getFirstName(): String

    fun getLastName(): String

    fun getEmail(): String

    @get:Value("#{target.firstName} #{target.lastName}")
    val fullName: String

}