package bzh.msansm1.trevadserver.user

import bzh.msansm1.trevadserver.model.internalServerError
import org.springframework.http.MediaType

class UserRouter(private val userHandler: UserHandler) {

    fun router() = org.springframework.web.reactive.function.server.router {
        "/api/v1/users".nest {
            accept(MediaType.APPLICATION_JSON).nest {
                GET("/", userHandler::getAll)
                POST("/", userHandler::createUpdate)
                GET("/{id}", userHandler::getUser)
                POST("/profile", userHandler::updateCurrentUser)
            }
        }
    }
    .filter { request, next ->
        try {
            next.handle(request)
        } catch (ex: Exception) {
            internalServerError(ex)
        }
    }

}