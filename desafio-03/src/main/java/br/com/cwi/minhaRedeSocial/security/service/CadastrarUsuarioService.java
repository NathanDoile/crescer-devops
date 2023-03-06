package br.com.cwi.minhaRedeSocial.security.service;

import br.com.cwi.minhaRedeSocial.security.controller.request.CadastrarUsuarioRequest;
import br.com.cwi.minhaRedeSocial.security.controller.response.CadastrarUsuarioResponse;
import br.com.cwi.minhaRedeSocial.security.domain.Permissao;
import br.com.cwi.minhaRedeSocial.security.domain.Usuario;
import br.com.cwi.minhaRedeSocial.security.repository.PermissaoRepository;
import br.com.cwi.minhaRedeSocial.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static br.com.cwi.minhaRedeSocial.security.mapper.CadastrarUsuarioMapper.toEntity;
import static br.com.cwi.minhaRedeSocial.security.mapper.CadastrarUsuarioMapper.toResponse;

@Service
public class CadastrarUsuarioService {

    @Autowired
    private ValidarEmailService validarEmailService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PermissaoRepository permissaoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public CadastrarUsuarioResponse cadastrar(CadastrarUsuarioRequest request) {

        validarEmailService.validar(request.getEmail());
        Usuario entity = toEntity(request);
        entity.setSenha(passwordEncoder.encode(entity.getSenha()));
        entity.setAtivo(true);
        entity.setPermissoes(new ArrayList<>());
        /*entity.setAmigos(new ArrayList<>());
        entity.setSolicitacoes(new ArrayList<>());
        entity.setPostagens(new ArrayList<>());
        entity.setCurtidas(new ArrayList<>());
        entity.setComentarios(new ArrayList<>());*/

        usuarioRepository.save(entity);

        Permissao permissao = Permissao
                .builder()
                .nome("USUARIO")
                .build();

        entity.adicionarPermissao(permissao);
        permissaoRepository.save(permissao);

        return toResponse(entity);
    }

}
