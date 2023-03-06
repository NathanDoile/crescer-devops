package br.com.cwi.minhaRedeSocial.security.mapper;

import br.com.cwi.minhaRedeSocial.security.domain.Postagem;
import br.com.cwi.minhaRedeSocial.security.controller.request.PublicarUsuarioRequest;
import br.com.cwi.minhaRedeSocial.security.controller.response.PublicarUsuarioResponse;

public class PublicarUsuarioMapper {


    public static Postagem toEntity(PublicarUsuarioRequest request) {

        return Postagem
                .builder()
                .dataPostagem(request.getDataPostagem())
                .privacidade(request.getPrivacidade())
                .imagem(request.getImagem())
                .mensagem(request.getMensagem())
                .build();
    }

    public static PublicarUsuarioResponse toResponse(Postagem postagem) {

        return PublicarUsuarioResponse
                .builder()
                .id(postagem.getId())
                .build();
    }
}
