package com.backend.api.services

import com.backend.api.documents.Funcionario
import com.backend.api.enums.PerfilEnum
import com.backend.api.repositories.FuncionarioRepository
import com.backend.api.utils.SenhaUtils
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import java.util.*

@SpringBootTest
@DisplayName("Testando a Classe de Funcionario Services")
class FuncionarioServiceTest {

    @Autowired
    private val funcionarioService: FuncionarioService? = null

    @MockBean
    private val funcionarioRepository: FuncionarioRepository? = null

    private val email: String = "edwin.desenv@gmail.com"
    private val cpf: String = "92425457089"
    private val id: String = "1"

    @BeforeEach
    @Throws(Exception::class)
    fun setUp() {
        BDDMockito.given(funcionarioRepository?.save(Mockito.any(Funcionario::class.java)))
            .willReturn(funcionario())

        BDDMockito.given(funcionarioRepository?.findById(id)).willReturn(Optional.of(funcionario()))

        BDDMockito.given(funcionarioRepository?.findByEmail(email)).willReturn(funcionario())

        BDDMockito.given(funcionarioRepository?.findByCpf(cpf)).willReturn(funcionario())
    }

    @Test
    fun testPersistirFuncionario(){
        val funcionario: Funcionario? = this.funcionarioService?.persistir(funcionario())
        Assertions.assertNotNull(funcionario)
    }

    @Test
    fun testBuscarFuncionarioPorCpf(){
        val funcionario: Funcionario? = this.funcionarioService?.buscarPorCpf(cpf)
        Assertions.assertNotNull(funcionario)
    }

    @Test
    fun testBuscarFuncionarioPorEmail(){
        val funcionario: Funcionario? = this.funcionarioService?.buscarPorEmail(email)
        Assertions.assertNotNull(funcionario)
    }

    @Test
    fun testBuscarFuncionarioPorId() {
        val funcionario: Funcionario? = this.funcionarioService?.buscarPorId(id)
        Assertions.assertNotNull(funcionario)
    }

    private fun funcionario() : Funcionario = Funcionario("Nome", email,
        SenhaUtils().gerarBcrypt("123456"), cpf, PerfilEnum.ROLE_USUARIO, id)

}