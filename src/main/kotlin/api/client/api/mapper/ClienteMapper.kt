package api.client.api.mapper

import api.client.api.dto.ClienteRequest
import api.client.domain.entity.RetrieveClienteDataParams
import java.time.LocalDate
import java.time.format.DateTimeParseException
import java.time.temporal.ChronoUnit

object ClienteMapper {

    fun toDomain(clienteRequestDto: ClienteRequest): RetrieveClienteDataParams {
        try {
            val cliente = clienteRequestDto.cliente

            val client = RetrieveClienteDataParams(
                    cliente.nome,
                    cliente.cpf,
                    cliente.idade,
                    cliente.data_nascimento,
                    cliente.uf,
                    cliente.renda_mensal,
                    cliente.email,
                    cliente.telefone_whatsapp
            )

            return client
        } catch (e: DateTimeParseException) {
            throw IllegalArgumentException("Data de nascimento inválida: ${e.message}")
        } catch (e: IllegalArgumentException) {
            throw IllegalArgumentException(e.message)
        }
    }
}