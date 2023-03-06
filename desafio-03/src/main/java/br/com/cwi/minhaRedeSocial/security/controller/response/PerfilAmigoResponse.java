package br.com.cwi.minhaRedeSocial.security.controller.response;

import br.com.cwi.minhaRedeSocial.security.domain.Postagem;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PerfilAmigoResponse {

    private String nomeCompleto;

    private String email;

    private String apelido;

    private LocalDate dataNascimento;

    private String imagemPerfil;

    private String seriePreferida;

    private List<Postagem> postagens = new ArrayList<>();
}
