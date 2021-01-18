package com.backend.api.dtos

data class LancamentoDto (
    //@get:NotEmpty(message = "Data não pode ser vazia.")
    val data: String? = null,

    //@get:NotEmpty(message = "Data não pode ser vazia.")
    val tipo: String? = null,
    val descricao: String? = null,
    val localizacao: String? = null,
    val funcionarioId: String? = null,
    val id: String? = null
)