package br.com.jonyfs.springbootkotlinapi.role

/**
 * Created by jony on 25/05/17.
 */


import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface RoleRepository : PagingAndSortingRepository<Role, Long>