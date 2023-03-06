package br.com.cwi.minhaRedeSocial.factory;

import br.com.cwi.minhaRedeSocial.security.controller.request.CadastrarUsuarioRequest;

import java.time.LocalDate;

public class CadastrarUsuarioRequestFactory {

    public static CadastrarUsuarioRequest getUsuario() {

        return CadastrarUsuarioRequest
                .builder()
                .nomeCompleto("Nome Completo Teste")
                .email("email.teste@cwi.com.br")
                .apelido("ApelidoTest")
                .dataNascimento(LocalDate.of(2002, 03, 18))
                .senha("SenhaDeTeste")
                .imagemPerfil("UrlDeTeste")
                .seriePreferida("SerieDeTeste")
                .build();
    }
}
