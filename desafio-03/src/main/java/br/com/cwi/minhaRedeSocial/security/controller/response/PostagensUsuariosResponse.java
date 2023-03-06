package br.com.cwi.minhaRedeSocial.security.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostagensUsuariosResponse {

    private Long id;

    private String nomeUsuarioPostagem;

    private String imagemUsuarioPostagem;

    private LocalDate dataPostagem;

    private String imagem;

    private String mensagem;
}
