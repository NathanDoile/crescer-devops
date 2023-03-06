package br.com.cwi.minhaRedeSocial.mapper;

import br.com.cwi.minhaRedeSocial.factory.UsuarioFactory;
import br.com.cwi.minhaRedeSocial.security.controller.response.BuscarUsuariosResponse;
import br.com.cwi.minhaRedeSocial.security.domain.Usuario;
import br.com.cwi.minhaRedeSocial.security.mapper.BuscarUsuariosMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class BuscarUsuariosMapperTest {

    @InjectMocks
    private BuscarUsuariosMapper tested;

    @Test
    @DisplayName("Deve mappear corretamente para response")
    void deveMappearCorretamente(){

        Usuario usuario = UsuarioFactory.getDisponivel();

        BuscarUsuariosResponse retorno = tested.toResponse(usuario);

        assertEquals(usuario.getId(),retorno.getId());
        assertEquals(usuario.getImagemPerfil(), retorno.getImagemPefil());
        assertEquals(usuario.getNomeCompleto(), retorno.getNomeCompleto());
        assertEquals(usuario.getEmail(), retorno.getEmail());
    }
}
