package api.client.domain.ports.processor

import api.client.domain.entity.ClienteData
import api.client.domain.entity.RetrieveClienteDataParams

interface ClienteProcessorProvider {

    fun sendData(retrieveClienteDataParams: RetrieveClienteDataParams): ClienteData
}