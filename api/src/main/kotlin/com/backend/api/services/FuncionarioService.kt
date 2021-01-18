package com.backend.api.services

import com.backend.api.documents.Funcionario
import java.util.*

interface FuncionarioService {

    fun persistir(funcionario: Funcionario) : Funcionario

    fun buscarPorCpf(cpf: String) : Funcionario?

    fun buscarPorEmail(email: String) : Funcionario?

    fun buscarPorId(id: String): Funcionario?

}