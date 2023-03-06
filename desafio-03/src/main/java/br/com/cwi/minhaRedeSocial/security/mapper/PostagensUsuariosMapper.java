package br.com.cwi.minhaRedeSocial.security.mapper;

import br.com.cwi.minhaRedeSocial.security.domain.Postagem;
import br.com.cwi.minhaRedeSocial.security.controller.response.PostagensUsuariosResponse;

public class PostagensUsuariosMapper {


    public static PostagensUsuariosResponse toResponse(Postagem postagem) {

        return PostagensUsuariosResponse
                .builder()
                .id(postagem.getId())
                .dataPostagem(postagem.getDataPostagem())
                .mensagem(postagem.getMensagem())
                .imagemUsuarioPostagem(postagem.getUsuarioPostagem().getImagemPerfil())
                .imagem(postagem.getImagem())
                .nomeUsuarioPostagem(postagem.getUsuarioPostagem().getNomeCompleto())
                .build();
    }
}
