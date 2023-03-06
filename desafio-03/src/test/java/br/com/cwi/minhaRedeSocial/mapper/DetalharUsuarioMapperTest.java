package br.com.cwi.minhaRedeSocial.mapper;

import br.com.cwi.minhaRedeSocial.factory.UsuarioFactory;
import br.com.cwi.minhaRedeSocial.security.controller.response.DetalharUsuarioResponse;
import br.com.cwi.minhaRedeSocial.security.domain.Usuario;
import br.com.cwi.minhaRedeSocial.security.mapper.DetalharUsuarioMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class DetalharUsuarioMapperTest {

    @InjectMocks
    private DetalharUsuarioMapper tested;

    @Test
    @DisplayName("Deve mappear corretamente para response")
    void deveMappearCorretamente(){

        Usuario usuario = UsuarioFactory.getDisponivel();

        DetalharUsuarioResponse retorno = tested.toResponse(usuario);

        assertEquals(usuario.getNomeCompleto(), retorno.getNomeCompleto());
        assertEquals(usuario.getEmail(), retorno.getEmail());
        assertEquals(usuario.getApelido(), retorno.getApelido());
        assertEquals(usuario.getDataNascimento(),retorno.getDataNascimento());
        assertEquals(usuario.getImagemPerfil(),retorno.getImagemPerfil());
        assertEquals(usuario.getSeriePreferida(),retorno.getSeriePreferida());
    }
}
