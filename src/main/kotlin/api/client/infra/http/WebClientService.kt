package api.client.infra.http

import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.WebClientResponseException
import reactor.core.publisher.Mono

@Service
class WebClientService(
        private val webClient: WebClient,

        @Value("\${external.api.url}") private val apiUrl: String,
        @Value("\${external.api.uri}") private val uri: String) {

    fun getCardsOffers(id: String): Mono<ResponseEntity<String>> {
        val url = "$apiUrl/$uri/$id"

        return webClient.get()
                .uri(url)
                .retrieve()
                .toEntity(String::class.java)
                .onErrorResume(WebClientResponseException::class.java) { ex ->
                    val headers = HttpHeaders()
                    headers.contentType = MediaType.APPLICATION_JSON
                    Mono.just(
                            ResponseEntity
                                    .status(ex.statusCode)
                                    .headers(headers)
                                    .body(ex.responseBodyAsString)
                    )
                }
                .onErrorResume(Exception::class.java) {
                    val headers = HttpHeaders()
                    headers.contentType = MediaType.APPLICATION_JSON
                    Mono.just(ResponseEntity.internalServerError().headers(headers).body("Erro inesperado ao chamar API externa"))
        }
    }
}