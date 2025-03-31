package api.client.api.resource

import api.client.api.dto.ClienteRequest
import api.client.api.mapper.ClienteMapper
import api.client.api.service.impl.ClientServiceImpl
import api.client.domain.entity.ClienteData
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/cartoes")
class ClientResource(private val service: ClientServiceImpl) {

    @PostMapping
    fun client(@RequestBody clienteRequest: ClienteRequest): ResponseEntity<ClienteData> {
        val retrieveClienteDataParams = ClienteMapper.toDomain(clienteRequest)
        val clienteData = service.processClient(retrieveClienteDataParams)
        return ResponseEntity.ok(clienteData)
    }
}