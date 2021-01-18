package com.backend.api.services

import com.backend.api.documents.Empresa
import com.backend.api.repositories.EmpresaRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.util.Assert

@SpringBootTest
class EmpresaServiceTest {

    @Autowired
    private val empresaService: EmpresaService? = null

    @MockBean
    private val empresaRepository: EmpresaRepository? = null

    private val CNPJ = "90676013000178"

    @BeforeEach
    @Throws(Exception::class)
    fun setUp(){
        BDDMockito.given(empresaRepository?.findByCnpj(CNPJ)).willReturn(empresa())
        BDDMockito.given(empresaRepository?.save(empresa())).willReturn(empresa())
    }

    @Test
    fun testBuscarEmpresaCnpj(){
        val empresa: Empresa? = empresaService?.buscarPorCnpj(CNPJ)
        Assert.notNull(empresa, "Error ao buscar cnpj")
    }

    @Test
    fun testPersistirEmpresa(){
        val empresa: Empresa? = empresaService?.persistir(empresa())
        Assert.notNull(empresa, "Error ao persistir empresa")
    }

    private fun empresa() : Empresa = Empresa(razaoSocial = "Empresa Edwin", CNPJ, id = "1")
}