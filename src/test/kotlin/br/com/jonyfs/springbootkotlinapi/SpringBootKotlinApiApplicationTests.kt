package br.com.jonyfs.springbootkotlinapi

import br.com.jonyfs.springbootkotlinapi.privilege.PrivilegeRepository
import br.com.jonyfs.springbootkotlinapi.role.RoleRepository
import br.com.jonyfs.springbootkotlinapi.user.User
import br.com.jonyfs.springbootkotlinapi.user.UserRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.json.JacksonTester
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.context.ApplicationContext
import org.springframework.http.ResponseEntity
import org.springframework.test.context.junit4.SpringRunner
import javax.annotation.Resource


@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootKotlinApiApplicationTests {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Resource
    private val applicationContext: ApplicationContext? = null

    @Resource
    lateinit var userRepository: UserRepository

    @Resource
    lateinit var roleRepository: RoleRepository

    @Resource
    lateinit var privilegeRepository: PrivilegeRepository

    @Autowired
    private val json: JacksonTester<User>? = null


    @Test
    fun testIfContextLoads() {
        assertThat(applicationContext).isNotNull()
    }

    @Test
    fun testIfApiLoads() {

        var user = User()
        user.firstName = "John"
        user.lastName = "Anderson"
        user.email = "john.anderson@test.com"
        user.password = "XPTO"


        user = userRepository.save(user)

        assertThat(user).isNotNull()
        assertThat(user.id).isNotNull()
        assertThat(user.firstName).isNotNull()

        var response: ResponseEntity<User> = restTemplate.getForEntity("/users/" + user.id, User::class.java)

        assertThat(response).isNotNull()

        var savedUser = response.body

        assertThat(savedUser).isNotNull()
        assertThat(savedUser.firstName).isNotNull()


        var user2 = User()
        user2.firstName = "John"
        user2.lastName = "Silva"
        user2.email = "john.silva@test.com"
        user2.password = "XPTO"

        response = restTemplate.postForEntity("/users", user2, User::class.java)

        assertThat(response.body).isNotNull()
        assertThat(response.body.firstName).isEqualTo(user.firstName)
        assertThat(response.headers["location"]).isNotNull


    }

}
