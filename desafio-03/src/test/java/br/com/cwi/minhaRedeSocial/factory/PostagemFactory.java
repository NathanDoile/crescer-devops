package br.com.cwi.minhaRedeSocial.factory;

import br.com.cwi.minhaRedeSocial.security.domain.Postagem;
import br.com.cwi.minhaRedeSocial.security.domain.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;

import static br.com.cwi.minhaRedeSocial.security.domain.Privacidade.PUBLICA;

public class PostagemFactory {

    public static Postagem get() {

        Usuario usuario = UsuarioFactory.getDisponivel();

        return Postagem
                .builder()
                .id(1L)
                .dataPostagem(LocalDate.of(2023, 02, 26))
                .ativo(true)
                .usuarioPostagem(usuario)
                .imagem("URL")
                .privacidade(PUBLICA)
                .mensagem("Mensagem")
                .comentario(new ArrayList<>())
                .curtidas(new ArrayList<>())
                .build();
    }
}
