package br.com.cwi.minhaRedeSocial.mapper;

import br.com.cwi.minhaRedeSocial.factory.CadastrarUsuarioRequestFactory;
import br.com.cwi.minhaRedeSocial.factory.UsuarioFactory;
import br.com.cwi.minhaRedeSocial.security.controller.request.CadastrarUsuarioRequest;
import br.com.cwi.minhaRedeSocial.security.controller.response.CadastrarUsuarioResponse;
import br.com.cwi.minhaRedeSocial.security.domain.Usuario;
import br.com.cwi.minhaRedeSocial.security.mapper.CadastrarUsuarioMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CadastrarUsuarioMapperTest {

    @InjectMocks
    private CadastrarUsuarioMapper tested;

    @Test
    @DisplayName("Deve mappear corretamente para entidade")
    void deveMappearCorretamenteParaEntidade(){

        CadastrarUsuarioRequest request = CadastrarUsuarioRequestFactory.getUsuario();

        Usuario retorno = tested.toEntity(request);

        assertEquals(request.getNomeCompleto(), retorno.getNomeCompleto());
        assertEquals(request.getEmail(), retorno.getEmail());
        assertEquals(request.getApelido(), retorno.getApelido());
        assertEquals(request.getDataNascimento(),retorno.getDataNascimento());
        assertEquals(request.getSenha(),retorno.getSenha());
        assertEquals(request.getImagemPerfil(),retorno.getImagemPerfil());
        assertEquals(request.getSeriePreferida(),retorno.getSeriePreferida());
    }

    @Test
    @DisplayName("Deve mappear corretamente para response")
    void deveMappearCorretamenteParaResponse(){

        Usuario usuario = UsuarioFactory.getDisponivel();

        CadastrarUsuarioResponse retorno = tested.toResponse(usuario);

        assertEquals(usuario.getId(),retorno.getId());
    }
}
