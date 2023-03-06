package br.com.cwi.minhaRedeSocial.service;

import br.com.cwi.minhaRedeSocial.factory.EditarUsuarioRequestFactory;
import br.com.cwi.minhaRedeSocial.factory.UsuarioFactory;
import br.com.cwi.minhaRedeSocial.security.controller.request.EditarUsuarioRequest;
import br.com.cwi.minhaRedeSocial.security.domain.Usuario;
import br.com.cwi.minhaRedeSocial.security.repository.UsuarioRepository;
import br.com.cwi.minhaRedeSocial.security.service.EditarUsuarioService;
import br.com.cwi.minhaRedeSocial.security.service.UsuarioAutenticadoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EditarUsuarioServiceTest {

    @InjectMocks
    private EditarUsuarioService tested;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Test
    @DisplayName("Deve editar usuario corretamente")
    void deveEditarUsuarioCorretamente(){

        EditarUsuarioRequest request = EditarUsuarioRequestFactory.get();

        Usuario usuario = UsuarioFactory.getDisponivel();

        when(usuarioAutenticadoService.get()).thenReturn(usuario);

        tested.editar(request);

        verify(usuarioAutenticadoService).get();
        verify(usuarioRepository).save(usuario);

        assertEquals(request.getApelido(), usuario.getApelido());
        assertEquals(request.getNomeCompleto(), usuario.getNomeCompleto());
        assertEquals(request.getImagemPerfil(), usuario.getImagemPerfil());
    }
}
