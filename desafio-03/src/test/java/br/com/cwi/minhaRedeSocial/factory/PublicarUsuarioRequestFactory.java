package br.com.cwi.minhaRedeSocial.factory;

import br.com.cwi.minhaRedeSocial.security.controller.request.PublicarUsuarioRequest;

import java.time.LocalDate;

import static br.com.cwi.minhaRedeSocial.security.domain.Privacidade.PUBLICA;

public class PublicarUsuarioRequestFactory {


    public static PublicarUsuarioRequest get() {

        return PublicarUsuarioRequest
                .builder()
                .dataPostagem(LocalDate.of(2023, 02, 25))
                .imagem("URL")
                .mensagem("Mensagem de teste")
                .privacidade(PUBLICA)
                .build();
    }
}
