package br.com.alura.codechella.config;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.application.usecases.CriarUsuario;
import br.com.alura.codechella.application.usecases.ListarUsuarios;
import br.com.alura.codechella.infra.gateways.RepositorioDeUsuarioJPA;
import br.com.alura.codechella.infra.gateways.UsuarioEntityMapper;
import br.com.alura.codechella.infra.persistance.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    //a anotação Bean abaixo indica que irá ocorrer uma injeção de dependência, quando for necessário
    @Bean
    CriarUsuario criarUsuario(RepositorioDeUsuario repositorioDeUsuario){
        return new CriarUsuario(repositorioDeUsuario);
    }

    @Bean
    RepositorioDeUsuarioJPA criarReopRepositorioDeUsuarioJPA(UsuarioRepository usuarioRepository, UsuarioEntityMapper usuarioEntityMapper){
        return new RepositorioDeUsuarioJPA(usuarioRepository, usuarioEntityMapper);
    }

    @Bean
    UsuarioEntityMapper retornarEntityMapper(){
        return new UsuarioEntityMapper();
    }

    @Bean
    ListarUsuarios listarUsuarios(RepositorioDeUsuario repositorioDeUsuario){
        return new ListarUsuarios(repositorioDeUsuario);
    }

}
