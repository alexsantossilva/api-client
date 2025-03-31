package api.client.domain.usecase.impl

import api.client.domain.entity.ClienteData
import api.client.domain.entity.RetrieveClienteDataParams
import api.client.domain.ports.processor.ClienteProcessorProvider
import api.client.domain.usecase.ProcessClienteUseCase

class ProcessClienteUseCaseImpl(private val clienteProcessorProvider: ClienteProcessorProvider) : ProcessClienteUseCase {

    override fun process(retrieveClienteDataParams: RetrieveClienteDataParams): ClienteData {

        return clienteProcessorProvider.sendData(retrieveClienteDataParams)
    }
}