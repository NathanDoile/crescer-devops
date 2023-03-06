package br.com.cwi.minhaRedeSocial.security.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DetalharUsuarioResponse {

    private String nomeCompleto;

    private String email;

    private String apelido;

    private LocalDate dataNascimento;

    private String imagemPerfil;

    private String seriePreferida;
}
