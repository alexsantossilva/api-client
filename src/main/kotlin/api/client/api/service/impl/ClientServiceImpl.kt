package api.client.api.service.impl

import api.client.api.service.ClientService
import api.client.domain.entity.ClienteData
import api.client.domain.entity.RetrieveClienteDataParams
import api.client.domain.usecase.ProcessClienteUseCase
import api.client.infra.http.WebClientService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.http.ResponseEntity
import reactor.core.publisher.Mono

@Service
class ClientServiceImpl(
        @Autowired private val webClientService: WebClientService,
        private val processClienteUseCase: ProcessClienteUseCase) : ClientService {

    override fun processClient(retrieveClienteDataParams: RetrieveClienteDataParams): ClienteData {
        return processClienteUseCase.process(retrieveClienteDataParams)
    }

    override fun getCardsOffers(id: String): Mono<ResponseEntity<String>> {
        return webClientService.getCardsOffers(id)
    }
}