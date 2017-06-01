package br.com.jonyfs.springbootkotlinapi.model

import org.hibernate.validator.constraints.NotEmpty
import javax.persistence.MappedSuperclass


/**
 * Created by jony on 27/05/17.
 */

@MappedSuperclass
abstract class NamedEntity : AuditableEntity() {

    @NotEmpty
    var name: String? = null
}