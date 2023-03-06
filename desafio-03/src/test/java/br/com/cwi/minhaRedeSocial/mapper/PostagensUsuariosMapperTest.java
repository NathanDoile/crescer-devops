package br.com.cwi.minhaRedeSocial.mapper;

import br.com.cwi.minhaRedeSocial.factory.PostagemFactory;
import br.com.cwi.minhaRedeSocial.security.controller.response.PostagensUsuariosResponse;
import br.com.cwi.minhaRedeSocial.security.domain.Postagem;
import br.com.cwi.minhaRedeSocial.security.mapper.PostagensUsuariosMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class PostagensUsuariosMapperTest {

    @InjectMocks
    private PostagensUsuariosMapper tested;

    @Test
    @DisplayName("Deve mappear corretamente para response")
    void deveMappearCorretamente(){

        Postagem postagem = PostagemFactory.get();

        PostagensUsuariosResponse retorno = tested.toResponse(postagem);

        assertEquals(postagem.getId(), retorno.getId());
        assertEquals(postagem.getDataPostagem(), retorno.getDataPostagem());
        assertEquals(postagem.getMensagem(), retorno.getMensagem());
        assertEquals(postagem.getUsuarioPostagem().getImagemPerfil(), retorno.getImagemUsuarioPostagem());
        assertEquals(postagem.getImagem(), retorno.getImagem());
        assertEquals(postagem.getUsuarioPostagem().getNomeCompleto(), retorno.getNomeUsuarioPostagem());
    }
}
