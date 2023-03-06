package br.com.cwi.minhaRedeSocial.security.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EditarUsuarioRequest {

    @NotBlank
    private String nomeCompleto;

    @NotBlank
    private String apelido;

    @NotBlank
    private String imagemPerfil;
}
