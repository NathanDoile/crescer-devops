package br.com.cwi.minhaRedeSocial.security.mapper;

import br.com.cwi.minhaRedeSocial.security.controller.response.DetalharUsuarioResponse;
import br.com.cwi.minhaRedeSocial.security.domain.Usuario;

public class DetalharUsuarioMapper {


    public static DetalharUsuarioResponse toResponse(Usuario usuario) {

        return DetalharUsuarioResponse
                .builder()
                .nomeCompleto(usuario.getNomeCompleto())
                .email(usuario.getEmail())
                .apelido(usuario.getApelido())
                .dataNascimento(usuario.getDataNascimento())
                .imagemPerfil(usuario.getImagemPerfil())
                .seriePreferida(usuario.getSeriePreferida())
                .build();
    }
}
