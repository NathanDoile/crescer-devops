package br.com.cwi.minhaRedeSocial.security.mapper;

import br.com.cwi.minhaRedeSocial.security.controller.request.CadastrarUsuarioRequest;
import br.com.cwi.minhaRedeSocial.security.controller.response.CadastrarUsuarioResponse;
import br.com.cwi.minhaRedeSocial.security.domain.Usuario;

public class CadastrarUsuarioMapper {

    public static Usuario toEntity(CadastrarUsuarioRequest request) {

        return Usuario
                .builder()
                .nomeCompleto(request.getNomeCompleto())
                .email(request.getEmail())
                .apelido(request.getApelido())
                .dataNascimento(request.getDataNascimento())
                .senha(request.getSenha())
                .imagemPerfil(request.getImagemPerfil())
                .seriePreferida(request.getSeriePreferida())
                .build();
    }

    public static CadastrarUsuarioResponse toResponse(Usuario entity) {

        return CadastrarUsuarioResponse
                .builder()
                .id(entity.getId())
                .build();
    }
}
