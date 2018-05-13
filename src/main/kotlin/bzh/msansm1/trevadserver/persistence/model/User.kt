package bzh.msansm1.trevadserver.persistence.model

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "users")
class User {

    @Id
    val id: UUID = UUID.randomUUID()
    val login: String? = null
    val password: String? = null
    val email: String? = null
    val mobileToken: String? = null
    val createdDate: CreatedDate? = null
    val lastConnection: Date? = null

}