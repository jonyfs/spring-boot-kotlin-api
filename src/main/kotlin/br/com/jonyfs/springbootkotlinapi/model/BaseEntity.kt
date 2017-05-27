package br.com.jonyfs.springbootkotlinapi.model

import org.springframework.data.annotation.LastModifiedDate
import java.io.Serializable
import java.util.*
import javax.persistence.Version


/**
 * Created by jony on 27/05/17.
 */

abstract class BaseEntity : Serializable {

    @Version var version: Long? = null
    @LastModifiedDate var date: Date? = null
}