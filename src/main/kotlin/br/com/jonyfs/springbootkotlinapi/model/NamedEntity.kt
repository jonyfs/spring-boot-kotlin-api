package br.com.jonyfs.springbootkotlinapi.model

import org.hibernate.validator.constraints.NotEmpty


/**
 * Created by jony on 27/05/17.
 */

abstract class NamedEntity : AuditableEntity<Long>() {

    @NotEmpty
    var name: String? = null
}