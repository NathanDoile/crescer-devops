package br.com.cwi.minhaRedeSocial.service;

import br.com.cwi.minhaRedeSocial.security.domain.Postagem;
import br.com.cwi.minhaRedeSocial.factory.PublicarUsuarioRequestFactory;
import br.com.cwi.minhaRedeSocial.factory.UsuarioFactory;
import br.com.cwi.minhaRedeSocial.security.controller.request.PublicarUsuarioRequest;
import br.com.cwi.minhaRedeSocial.security.controller.response.PublicarUsuarioResponse;
import br.com.cwi.minhaRedeSocial.security.domain.Usuario;
import br.com.cwi.minhaRedeSocial.security.repository.PostagemRepository;
import br.com.cwi.minhaRedeSocial.security.service.PublicarUsuarioService;
import br.com.cwi.minhaRedeSocial.security.service.UsuarioAutenticadoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PublicarUsuarioServiceTest {

    @InjectMocks
    private PublicarUsuarioService tested;

    @Mock
    private PostagemRepository postagemRepository;

    @Mock
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Captor
    private ArgumentCaptor<Postagem> postagemCaptor;

    @Test
    @DisplayName("Deve publicar quando o usuário está autenticado")
    void devePublicarUsuarioAutenticado(){

        PublicarUsuarioRequest request = PublicarUsuarioRequestFactory.get();

        Usuario usuario = UsuarioFactory.getDisponivel();

        when(usuarioAutenticadoService.get()).thenReturn(usuario);

        PublicarUsuarioResponse retorno = tested.publicar(request);

        verify(usuarioAutenticadoService).get();
        verify(postagemRepository).save(postagemCaptor.capture());

        Postagem postagem = postagemCaptor.getValue();

        assertEquals(request.getDataPostagem(), postagem.getDataPostagem());
        assertEquals(request.getMensagem(), postagem.getMensagem());
        assertEquals(request.getImagem(), postagem.getImagem());
        assertEquals(request.getPrivacidade(), postagem.getPrivacidade());
    }

    @Test
    @DisplayName("Não deve publicar quando o usuário não está autenticado")
    void naoDevePublicarUsuarioNaoAutenticado(){

        PublicarUsuarioRequest request = PublicarUsuarioRequestFactory.get();

        doThrow(ResponseStatusException.class).when(usuarioAutenticadoService).get();

        assertThrows(ResponseStatusException.class, () -> tested.publicar(request));

        verify(usuarioAutenticadoService).get();
    }
}
