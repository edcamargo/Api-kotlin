package com.backend.api.services

import com.backend.api.documents.Empresa

interface EmpresaService {

    fun buscarPorCnpj(cnpj: String) : Empresa?

    fun persistir(empresa: Empresa) : Empresa

}