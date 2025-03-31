package api.client.domain.entity

import api.client.domain.helper.DateHelper
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

data class RetrieveClienteDataParams(
        val nome: String,
        val cpf: String,
        val idade: Int,
        val data_nascimento: String,
        val uf: String,
        val renda_mensal: Double,
        val email: String,
        val telefone_whatsapp: String,
) {
    val id: UUID = UUID.randomUUID()
    val data_solicitacao: String = DateHelper.getStringDateTime()
}