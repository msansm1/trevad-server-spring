package bzh.msansm1.trevadserver.persistence.repository

import bzh.msansm1.trevadserver.persistence.model.User
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.data.mongodb.repository.Query
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*
import java.util.stream.Stream

@Repository
interface UserRepository : MongoRepository<User, UUID> {

    fun findAllImmutable(): Flux<User> = Flux.fromIterable(this.findAll())

    fun create(user: User): Mono<User> {
        this.insert(user)
        return this.findByLogin(user.login.toString())
    }

    fun update(user: User): Mono<User> {
        this.save(user)
        return this.findByLogin(user.login.toString())
    }

    @Query("{ 'login': ?0 }")
    fun findByLogin(login: String): Mono<User>

}