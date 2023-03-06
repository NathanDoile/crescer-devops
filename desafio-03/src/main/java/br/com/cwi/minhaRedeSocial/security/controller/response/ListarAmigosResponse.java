package br.com.cwi.minhaRedeSocial.security.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListarAmigosResponse {

    private Long id;

    private String nomeCompleto;

    private String imagemPerfil;
}
