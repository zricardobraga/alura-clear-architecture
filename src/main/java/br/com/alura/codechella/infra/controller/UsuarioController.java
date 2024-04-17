package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.CriarUsuario;
import br.com.alura.codechella.application.usecases.ListarUsuarios;
import br.com.alura.codechella.domain.entities.user.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final CriarUsuario criarUsuario;
    private final ListarUsuarios listarUsuarios;

    public UsuarioController(CriarUsuario criarUsuario, ListarUsuarios listarUsuarios) {
        this.criarUsuario = criarUsuario;
        this.listarUsuarios = listarUsuarios;
    }

    @PostMapping
    public UsuarioDTO cadastrarUsuario(@RequestBody UsuarioDTO usuarioDTO){
        Usuario usuarioSalvo = criarUsuario.cadastrarUsuario(new Usuario(usuarioDTO.cpf(), usuarioDTO.nome(), usuarioDTO.nascimento(), usuarioDTO.email()));

        return new UsuarioDTO(usuarioSalvo.getCpf(), usuarioSalvo.getNome(), usuarioSalvo.getNascimento(), usuarioSalvo.getEmail());
    }

    @GetMapping
    public List<UsuarioDTO> listarUsuarios(){
        return listarUsuarios.obterTodosUsuarios().stream()
                .map(usuario -> new UsuarioDTO(usuario.getCpf(), usuario.getNome(), usuario.getNascimento(), usuario.getEmail()))
                .collect(Collectors.toList());
    }
}
