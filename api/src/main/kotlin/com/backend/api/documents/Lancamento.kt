package com.backend.api.documents

import com.backend.api.enums.TipoEnum
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document
data class Lancamento (
    val data: Date,
    val tipoEnum: TipoEnum,
    val funcionarioId: String,
    val descricao: String? = "",
    val localizacao: String? = "",
    @Id val id: String? = null
)