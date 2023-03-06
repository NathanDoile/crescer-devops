package br.com.cwi.minhaRedeSocial.security.service;

import br.com.cwi.minhaRedeSocial.security.domain.Postagem;
import br.com.cwi.minhaRedeSocial.security.controller.response.PostagensUsuariosResponse;
import br.com.cwi.minhaRedeSocial.security.domain.Usuario;
import br.com.cwi.minhaRedeSocial.security.mapper.PostagensUsuariosMapper;
import br.com.cwi.minhaRedeSocial.security.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class PostagensUsuariosService {

    @Autowired
    private PostagemRepository postagemRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public Page<PostagensUsuariosResponse> postagens(Pageable pageable) {

        Usuario usuario = usuarioAutenticadoService.get();



        Page<Postagem> postagens = postagemRepository.findAllByUsuarioPostagemAndAtivo(usuario, true, pageable);

        for(int i = 0; i < usuario.getAmigos().size(); i++){

            Page<Postagem> postagensAmigos = postagemRepository.findAllByUsuarioPostagemAndAtivo(usuario.getAmigos().get(i).getAmigo(),
                    true, pageable);

            if(isNull(postagens)){
                postagens = postagensAmigos;
            }

            else{

                if(nonNull(postagensAmigos.getContent())){
                    postagens.getContent().addAll(postagensAmigos.getContent());
                }
            }
        }

        return postagens.map(PostagensUsuariosMapper::toResponse);
    }
}
