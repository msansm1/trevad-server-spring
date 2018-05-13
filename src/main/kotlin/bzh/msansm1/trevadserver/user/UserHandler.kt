package bzh.msansm1.trevadserver.user

import bzh.msansm1.trevadserver.persistence.model.User
import bzh.msansm1.trevadserver.persistence.repository.UserRepository
import bzh.msansm1.trevadserver.validate
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.ok
import org.springframework.web.reactive.function.server.body
import reactor.core.publisher.Mono
import java.util.*

class UserHandler(val userRepository: UserRepository) {

    fun getAll(req: ServerRequest): Mono<ServerResponse> = validate.request(req) {
        ok().body(userRepository.findAllImmutable())
    }

    fun getUser(req: ServerRequest): Mono<ServerResponse> = validate.request(req) {
        ok().body(Mono.just(userRepository.findById(UUID.fromString(req.pathVariable("id")))))
    }

    fun createUpdate(req: ServerRequest) = validate.request(req)
            .withBody(User::class.java) { user ->
                ok().body(userRepository.create(user))
            }

    fun updateCurrentUser(req: ServerRequest) = validate.request(req)
            .withBody(User::class.java) { user ->
                ok().body(userRepository.update(user))
            }

}