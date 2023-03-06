package br.com.cwi.minhaRedeSocial.security.mapper;

import br.com.cwi.minhaRedeSocial.security.controller.response.ListarAmigosResponse;
import br.com.cwi.minhaRedeSocial.security.domain.Usuario;

public class ListarAmigosMapper {

    public static ListarAmigosResponse toResponse(Usuario usuario) {

        return ListarAmigosResponse
                .builder()
                .id(usuario.getId())
                .imagemPerfil(usuario.getImagemPerfil())
                .nomeCompleto(usuario.getNomeCompleto())
                .build();
    }
}
