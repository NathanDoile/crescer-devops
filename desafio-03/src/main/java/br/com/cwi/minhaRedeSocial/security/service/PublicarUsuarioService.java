package br.com.cwi.minhaRedeSocial.security.service;

import br.com.cwi.minhaRedeSocial.security.domain.Postagem;
import br.com.cwi.minhaRedeSocial.security.controller.request.PublicarUsuarioRequest;
import br.com.cwi.minhaRedeSocial.security.controller.response.PublicarUsuarioResponse;
import br.com.cwi.minhaRedeSocial.security.domain.Usuario;
import br.com.cwi.minhaRedeSocial.security.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.cwi.minhaRedeSocial.security.mapper.PublicarUsuarioMapper.toEntity;
import static br.com.cwi.minhaRedeSocial.security.mapper.PublicarUsuarioMapper.toResponse;

@Service
public class PublicarUsuarioService {

    @Autowired
    private PostagemRepository postagemRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Transactional
    public PublicarUsuarioResponse publicar(PublicarUsuarioRequest request) {

        Postagem postagem = toEntity(request);

        Usuario usuario = usuarioAutenticadoService.get();
        usuario.adicionarPostagem(postagem);

        postagemRepository.save(postagem);

        return toResponse(postagem);
    }
}
