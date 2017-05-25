package br.com.jonyfs.springbootkotlinapi.privilege

/**
 * Created by jony on 25/05/17.
 */

import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.data.rest.core.annotation.RepositoryRestResource

@RepositoryRestResource
interface PrivilegeRepository : PagingAndSortingRepository<Privilege, Long>