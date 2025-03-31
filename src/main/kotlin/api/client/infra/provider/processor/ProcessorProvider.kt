package api.client.infra.provider.processor

import api.client.domain.entity.ClienteData
import api.client.domain.entity.RetrieveClienteDataParams
import api.client.domain.ports.processor.ClienteProcessorProvider
import api.client.infra.queue.Queue
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

class ProcessorProvider(private val queue: Queue) : ClienteProcessorProvider {
    override fun sendData(retrieveClienteDataParams: RetrieveClienteDataParams): ClienteData {
        queue.sendMessage(parse(
                retrieveClienteDataParams
        ))

        return ClienteData(retrieveClienteDataParams.id)
    }

    private fun parse(retrieveClienteDataParams: RetrieveClienteDataParams): String {
        val objectMapper = jacksonObjectMapper()
                .registerModule(JavaTimeModule())
        return objectMapper.writeValueAsString(retrieveClienteDataParams)
    }
}