package br.com.cwi.minhaRedeSocial.service;

import br.com.cwi.minhaRedeSocial.factory.UsuarioFactory;
import br.com.cwi.minhaRedeSocial.security.controller.response.DetalharUsuarioResponse;
import br.com.cwi.minhaRedeSocial.security.domain.Usuario;
import br.com.cwi.minhaRedeSocial.security.service.DetalharUsuarioService;
import br.com.cwi.minhaRedeSocial.security.service.UsuarioAutenticadoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DetalharUsuarioServiceTest {

    @InjectMocks
    private DetalharUsuarioService tested;

    @Mock
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Test
    @DisplayName("Deve retornar os detalhes do usuário quando estiver autenticado")
    void deveRetornarDetalhesAoSerAutenticado(){

        Usuario usuario = UsuarioFactory.getDisponivel();

        when(usuarioAutenticadoService.get()).thenReturn(usuario);

        DetalharUsuarioResponse retorno = tested.detalhar();

        verify(usuarioAutenticadoService).get();

        assertEquals(usuario.getNomeCompleto(), retorno.getNomeCompleto());
        assertEquals(usuario.getApelido(), retorno.getApelido());
        assertEquals(usuario.getDataNascimento(), retorno.getDataNascimento());
        assertEquals(usuario.getSeriePreferida(), retorno.getSeriePreferida());
        assertEquals(usuario.getEmail(), retorno.getEmail());
        assertEquals(usuario.getImagemPerfil(), retorno.getImagemPerfil());
    }

    @Test
    @DisplayName("Não deve retornar os detalhes do usuário quando não estiver autenticado")
    void naoDeveRetornarDetalhesAoNaoSerAutenticado(){

        doThrow(ResponseStatusException.class).when(usuarioAutenticadoService).get();

        assertThrows(ResponseStatusException.class, () -> tested.detalhar());

        verify(usuarioAutenticadoService).get();
    }
}
