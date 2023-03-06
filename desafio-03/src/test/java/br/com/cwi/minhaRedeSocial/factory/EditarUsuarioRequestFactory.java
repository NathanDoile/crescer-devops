package br.com.cwi.minhaRedeSocial.factory;

import br.com.cwi.minhaRedeSocial.security.controller.request.EditarUsuarioRequest;

public class EditarUsuarioRequestFactory {

    public static EditarUsuarioRequest get() {

        return EditarUsuarioRequest
                .builder()
                .apelido("Novo apelido")
                .imagemPerfil("Nova imagem")
                .nomeCompleto("Novo nome")
                .build();
    }
}
