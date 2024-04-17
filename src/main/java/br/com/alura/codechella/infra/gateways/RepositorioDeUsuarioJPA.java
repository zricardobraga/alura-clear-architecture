package br.com.alura.codechella.infra.gateways;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.user.Usuario;
import br.com.alura.codechella.infra.persistance.UsuarioEntity;
import br.com.alura.codechella.infra.persistance.UsuarioRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RepositorioDeUsuarioJPA implements RepositorioDeUsuario {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioEntityMapper entityMapper;


    public RepositorioDeUsuarioJPA(UsuarioRepository usuarioRepository, UsuarioEntityMapper entityMapper) {
        this.usuarioRepository = usuarioRepository;
        this.entityMapper = entityMapper;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        UsuarioEntity entity = entityMapper.toEntity(usuario);
        usuarioRepository.save(entity);
        return entityMapper.toDomain(entity);
    }

//    Explicação do que o método abaixo está fazendo:
//    3. Stream e map:
//    A expressão stream().map(usuarioEntity -> entityMapper.toDomain(usuarioEntity)) utiliza o paradigma funcional do Java Streams para processar a lista de entidades retornadas pelo repositório.
//    .stream() converte a lista retornada pelo findAll em um Stream, que permite processar os elementos da lista de forma sequencial.
//    .map(usuarioEntity -> entityMapper.toDomain(usuarioEntity)) aplica a função lambda usuarioEntity -> entityMapper.toDomain(usuarioEntity) a cada elemento do Stream.
//    A função lambda recebe um argumento usuarioEntity do tipo UsuarioEntity.
//    Inside the lambda, entityMapper.toDomain(usuarioEntity) calls a method (presumably on entityMapper) that converts the usuarioEntity (entity object) to a domain object of type Usuario.

//    4. Collectors.toList():
//    .collect(Collectors.toList()) finaliza a operação do Stream.
//    O método collect reúne os resultados da transformação aplicada no map em uma nova coleção.
//    Collectors.toList() especifica que a nova coleção deve ser uma lista.

    @Override
    public List<Usuario> listarTodos() {
        return this.usuarioRepository.findAll().stream().map(usuarioEntity -> entityMapper.toDomain(usuarioEntity)).collect(Collectors.toList());
    }
}
