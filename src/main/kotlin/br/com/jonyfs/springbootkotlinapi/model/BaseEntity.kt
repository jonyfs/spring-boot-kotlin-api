package br.com.jonyfs.springbootkotlinapi.model

import javax.persistence.MappedSuperclass


/**
 * Created by jony on 27/05/17.
 */

@MappedSuperclass
abstract class BaseEntity : AuditableEntity<Long>()