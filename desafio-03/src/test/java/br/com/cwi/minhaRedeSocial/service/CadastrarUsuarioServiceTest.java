package br.com.cwi.minhaRedeSocial.service;

import br.com.cwi.minhaRedeSocial.security.controller.request.CadastrarUsuarioRequest;
import br.com.cwi.minhaRedeSocial.security.domain.Usuario;
import br.com.cwi.minhaRedeSocial.security.repository.PermissaoRepository;
import br.com.cwi.minhaRedeSocial.security.repository.UsuarioRepository;
import br.com.cwi.minhaRedeSocial.security.service.CadastrarUsuarioService;
import br.com.cwi.minhaRedeSocial.security.service.ValidarEmailService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

import static br.com.cwi.minhaRedeSocial.factory.CadastrarUsuarioRequestFactory.getUsuario;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CadastrarUsuarioServiceTest {

    @InjectMocks
    private CadastrarUsuarioService tested;

    @Mock
    private ValidarEmailService validarEmailService;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private PermissaoRepository permissaoRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Captor
    private ArgumentCaptor<Usuario> usuarioCaptor;

    @Test
    @DisplayName("Deve cadastrar usuário com e-mail válido")
    void deveCadastrarUsuario(){

        CadastrarUsuarioRequest request = getUsuario();

        when(passwordEncoder.encode(request.getSenha())).thenReturn(request.getSenha());

        tested.cadastrar(request);

        verify(validarEmailService).validar(request.getEmail());

        verify(passwordEncoder).encode(request.getSenha());

        verify(usuarioRepository).save(usuarioCaptor.capture());

        Usuario usuario = usuarioCaptor.getValue();

        verify(permissaoRepository).save(usuario.getPermissoes().get(0));

        assertEquals(request.getNomeCompleto(), usuario.getNomeCompleto());
        assertEquals(request.getEmail(), usuario.getEmail());
        assertEquals(request.getSenha(), usuario.getSenha());
        assertEquals(request.getApelido(), usuario.getApelido());
        assertEquals(request.getImagemPerfil(), usuario.getImagemPerfil());
        assertEquals(request.getSeriePreferida(), usuario.getSeriePreferida());
        assertEquals(request.getDataNascimento(), usuario.getDataNascimento());
        assertTrue(usuario.isAtivo());
        assertEquals(1, usuario.getPermissoes().size());

    }

    @Test
    @DisplayName("Não deve cadastrar um usuário com e-mail inválido")
    void naoDeveCadastrarUsuarioEmailInvalido(){

        CadastrarUsuarioRequest request = getUsuario();

        doThrow(ResponseStatusException.class).when(validarEmailService).validar(request.getEmail());

        assertThrows(ResponseStatusException.class, () -> tested.cadastrar(request));

        verify(usuarioRepository, never()).save(any());

        verify(permissaoRepository, never()).save(any());
    }
}
