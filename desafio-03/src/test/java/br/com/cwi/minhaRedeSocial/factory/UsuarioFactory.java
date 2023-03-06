package br.com.cwi.minhaRedeSocial.factory;

import br.com.cwi.minhaRedeSocial.security.domain.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;

public class UsuarioFactory {

    public static Usuario getDisponivel() {
        return Usuario
                .builder()
                .id(1L)
                .nomeCompleto("Nome Completo de Teste")
                .email("email.teste@cwi.com.br")
                .apelido("Apelido")
                .dataNascimento(LocalDate.of(2023, 02, 25))
                .senha("123456")
                .imagemPerfil("URL")
                .ativo(true)
                .permissoes(new ArrayList<>())
                .postagens(new ArrayList<>())
                .build();
    }
}
