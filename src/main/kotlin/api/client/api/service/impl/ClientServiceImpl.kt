package api.client.api.service.impl

import api.client.api.service.ClientService
import api.client.domain.entity.ClienteData
import api.client.domain.entity.RetrieveClienteDataParams
import api.client.domain.usecase.ProcessClienteUseCase
import org.springframework.stereotype.Service

@Service
class ClientServiceImpl(private val processClienteUseCase: ProcessClienteUseCase) : ClientService {
    override fun processClient(retrieveClienteDataParams: RetrieveClienteDataParams): ClienteData {
        return processClienteUseCase.process(retrieveClienteDataParams)
    }
}