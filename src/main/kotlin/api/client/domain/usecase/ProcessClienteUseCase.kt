package api.client.domain.usecase

import api.client.domain.entity.ClienteData
import api.client.domain.entity.RetrieveClienteDataParams

interface ProcessClienteUseCase {

    fun process(retrieveClienteDataParams: RetrieveClienteDataParams): ClienteData
}