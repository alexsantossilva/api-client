package api.client.api.dto

import com.fasterxml.jackson.annotation.JsonProperty

class ClienteRequest(
        @JsonProperty("cliente")
        val cliente: Cliente
)