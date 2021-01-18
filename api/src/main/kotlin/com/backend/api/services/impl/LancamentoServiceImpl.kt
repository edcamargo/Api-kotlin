package com.backend.api.services.impl

import com.backend.api.documents.Lancamento
import com.backend.api.repositories.LancamentoRepository
import com.backend.api.services.LancamentoService
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class LancamentoServiceImpl(val lancamentoRepository: LancamentoRepository) : LancamentoService {

    override fun persistir(lancamento: Lancamento): Lancamento
        = lancamentoRepository.save(lancamento)

    override fun buscarPorFuncionarioId(funcionarioId: String, pageRequest: PageRequest): Page<Lancamento>
        = lancamentoRepository.findByFuncionarioId(funcionarioId, pageRequest)

    override fun buscarPorId(id: String): Lancamento?
        = lancamentoRepository.findById(id).get()

    override fun remover(id: String) = lancamentoRepository.deleteById(id)

}