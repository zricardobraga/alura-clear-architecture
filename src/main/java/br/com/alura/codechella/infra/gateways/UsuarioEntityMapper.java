package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.domain.entities.user.Usuario;
import br.com.alura.codechella.infra.persistance.UsuarioEntity;

public class UsuarioEntityMapper {

    //converte um o usuário de dominio, ou seja, o que está no pacote domain, e converte para o uma entidade a ser salva no banco de dados
    public UsuarioEntity toEntity(Usuario usuario){
        return new UsuarioEntity(usuario.getCpf(), usuario.getNome(), usuario.getNascimento(), usuario.getEmail());
    }

    //faz o contrário do método acima
    public Usuario toDomain(UsuarioEntity usuarioEntity){
        return new Usuario(usuarioEntity.getCpf(), usuarioEntity.getNome(), usuarioEntity.getNascimento(), usuarioEntity.getEmail());
    }

}
