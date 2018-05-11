package bzh.msansm1.trevadserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TrevadServerApplication

fun main(args: Array<String>) {
    runApplication<TrevadServerApplication>(*args)
}
