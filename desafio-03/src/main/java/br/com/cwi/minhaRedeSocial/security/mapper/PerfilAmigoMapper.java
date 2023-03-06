package br.com.cwi.minhaRedeSocial.security.mapper;

import br.com.cwi.minhaRedeSocial.security.controller.response.PerfilAmigoResponse;
import br.com.cwi.minhaRedeSocial.security.domain.Usuario;
import com.fasterxml.jackson.annotation.JsonInclude;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonInclude(NON_NULL)
public class PerfilAmigoMapper {


    public static PerfilAmigoResponse toResponse(Usuario entity) {

        return PerfilAmigoResponse
                .builder()
                .apelido(entity.getApelido())
                .dataNascimento(entity.getDataNascimento())
                .email(entity.getEmail())
                .imagemPerfil(entity.getImagemPerfil())
                .nomeCompleto(entity.getNomeCompleto())
                .postagens(entity.getPostagens())
                .seriePreferida(entity.getSeriePreferida())
                .build();
    }
}
