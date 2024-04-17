package br.com.alura.codechella.domain.entities.user;

import br.com.alura.codechella.domain.Endereco;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTeste {

    @Test
    public void naoDeveCadastrarUsuarioComCpfNoFormatoInvalido(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Usuario(
                "12345678999", "teste", LocalDate.parse("1990-10-01"), "email@email.com"));
    }

    @Test
    public void deveCriarUsuarioUsandoFabricaDeUsuario(){

        //preparo
        FabricaDeUsuario fabrica = new FabricaDeUsuario();

        Usuario usuario = fabrica.comNomeCpfNascimento("Emily", "654.123.897-88",
                LocalDate.parse("2000-10-01"));

        Assertions.assertEquals("Emily", usuario.getNome());

        usuario = fabrica.incluiEndereco("12345-999", 40, "apto 200");

        Assertions.assertEquals(40, usuario.getEndereco().getNumero());

    }

}
