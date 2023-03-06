package br.com.cwi.minhaRedeSocial.security.service;

import br.com.cwi.minhaRedeSocial.security.domain.Amigo;
import br.com.cwi.minhaRedeSocial.security.controller.response.ListarAmigosResponse;
import br.com.cwi.minhaRedeSocial.security.domain.Usuario;
import br.com.cwi.minhaRedeSocial.security.mapper.ListarAmigosMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ListarAmigosService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public Page<ListarAmigosResponse> listar(Pageable pageable) {

        Usuario usuario = usuarioAutenticadoService.get();

        List<Amigo> amigos = usuario.getAmigos();

        List<Usuario> amigosUsuario = new ArrayList<>();

        for(int i = 0; i < amigos.size(); i++){

            amigosUsuario.add(amigos.get(i).getAmigo());
        }

        Page<Usuario> amigosPage = new PageImpl<>(amigosUsuario);

        return amigosPage.map(ListarAmigosMapper::toResponse);
    }
}
