package api.client.api.service

import api.client.domain.entity.ClienteData
import api.client.domain.entity.RetrieveClienteDataParams

interface ClientService {
    fun processClient(retrieveClienteDataParams: RetrieveClienteDataParams): ClienteData
}