package br.com.cwi.minhaRedeSocial.security.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BuscarUsuariosResponse {

    private Long id;

    private String nomeCompleto;

    private String imagemPefil;

    private String email;
}
