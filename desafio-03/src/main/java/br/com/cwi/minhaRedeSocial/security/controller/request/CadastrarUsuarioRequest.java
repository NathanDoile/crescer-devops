package br.com.cwi.minhaRedeSocial.security.controller.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CadastrarUsuarioRequest {

    @NotBlank
    private String nomeCompleto;

    @NotBlank
    private String email;

    private String apelido;

    @NotNull
    private LocalDate dataNascimento;

    @NotBlank
    private String senha;

    private String imagemPerfil;

    @NotBlank
    private String seriePreferida;
}
