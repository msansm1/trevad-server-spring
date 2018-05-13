package bzh.msansm1.trevadserver

import bzh.msansm1.trevadserver.model.Error;
import io.github.cdimascio.swagger.Validate

val validate = Validate.configure("static/api.json") { status, messages ->
    Error(status.value(), messages)
}