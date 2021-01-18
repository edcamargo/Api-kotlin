package com.backend.api.dtos

//import org.hibernate.validator.constraints.NotEmpty

data class FuncionarioDto (
    //@get:NotEmpty(message = "Nome não pode ser vazio.")
    //@get:Length()
    val nome: String = "",
    val email: String = "",
    val senha: String? = null,
    val valorHora: String? = null,
    val qtdHorasTrabalhoDia: String? = null,
    val qtdHorasAlmoco: String? = null,
    val id: String? = null
)