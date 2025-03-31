package api.client.domain.helper

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object DateHelper {

    fun getStringDateTime(): String {
        val now = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS")

        return now.format(formatter)
    }
}