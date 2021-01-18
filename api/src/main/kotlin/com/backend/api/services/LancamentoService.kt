package com.backend.api.services

import com.backend.api.documents.Lancamento
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Page

interface LancamentoService {

    fun persistir(lancamento: Lancamento) : Lancamento

    fun buscarPorFuncionarioId(funcionarioId: String, pageRequest: PageRequest) : Page<Lancamento>

    fun buscarPorId(id: String) : Lancamento?

    fun remover(id: String)

}