package api.client.api.dto

import jakarta.validation.constraints.*

data class Cliente(

    @field:NotBlank(message = "O nome é obrigatório")
    val nome: String,

    @field:Pattern(
        regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}",
        message = "CPF inválido"
    )
    val cpf: String,

    @field:Min(value = 18, message = "Idade mínima é 18 anos")
    val idade: Int,

    @field:Pattern(
        regexp = "\\d{4}-\\d{2}-\\d{2}",
        message = "A data de nascimento deve estar no formato YYYY-MM-DD"
    )
    val data_nascimento: String,

    @field:Size(min = 2, max = 2, message = "UF deve ter 2 caracteres")
    val uf: String,

    @field:Positive(message = "A renda mensal deve ser maior que zero")
    val renda_mensal: Double,

    @field:Email(message = "E-mail inválido")
    val email: String,

    @field:Pattern(
    regexp = "\\d{11}",
    message = "O telefone deve conter 11 dígitos (DDD + número)"
    )
    val telefone_whatsapp: String
)
