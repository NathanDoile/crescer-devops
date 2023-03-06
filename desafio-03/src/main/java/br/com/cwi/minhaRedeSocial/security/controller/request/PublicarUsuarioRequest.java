package br.com.cwi.minhaRedeSocial.security.controller.request;

import br.com.cwi.minhaRedeSocial.security.domain.Privacidade;
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
public class PublicarUsuarioRequest {

    @NotNull
    private LocalDate dataPostagem;

    @NotNull
    private Privacidade privacidade;

    private String imagem;

    @NotBlank
    private String mensagem;
}
