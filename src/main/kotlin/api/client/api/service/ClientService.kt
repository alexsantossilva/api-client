package api.client.api.service

import api.client.domain.entity.ClienteData
import api.client.domain.entity.RetrieveClienteDataParams
import org.springframework.http.ResponseEntity
import reactor.core.publisher.Mono

interface ClientService {
    fun processClient(retrieveClienteDataParams: RetrieveClienteDataParams): ClienteData
    fun getCardsOffers(id: String): Mono<ResponseEntity<String>>
}