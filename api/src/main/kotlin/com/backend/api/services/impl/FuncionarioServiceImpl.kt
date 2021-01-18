package com.backend.api.services.impl

import com.backend.api.documents.Funcionario
import com.backend.api.repositories.FuncionarioRepository
import com.backend.api.services.FuncionarioService
import org.springframework.stereotype.Service
import java.util.*

@Service
class FuncionarioServiceImpl(val funcionarioRepository: FuncionarioRepository) : FuncionarioService {

    override fun persistir(funcionario: Funcionario): Funcionario
        = funcionarioRepository.save(funcionario)

    override fun buscarPorId(id: String)
        = funcionarioRepository.findById(id).get()

    override fun buscarPorCpf(cpf: String): Funcionario?
        = funcionarioRepository.findByCpf(cpf)

    override fun buscarPorEmail(email: String): Funcionario?
        = funcionarioRepository.findByEmail(email)

}