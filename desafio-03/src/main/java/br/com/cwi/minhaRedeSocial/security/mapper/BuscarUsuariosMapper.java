package br.com.cwi.minhaRedeSocial.security.mapper;

import br.com.cwi.minhaRedeSocial.security.controller.response.BuscarUsuariosResponse;
import br.com.cwi.minhaRedeSocial.security.domain.Usuario;

public class BuscarUsuariosMapper {

    public static BuscarUsuariosResponse toResponse(Usuario usuario) {

        return BuscarUsuariosResponse
                .builder()
                .id(usuario.getId())
                .imagemPefil(usuario.getImagemPerfil())
                .nomeCompleto(usuario.getNomeCompleto())
                .email(usuario.getEmail())
                .build();
    }
}
