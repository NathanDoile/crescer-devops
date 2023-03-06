package br.com.cwi.minhaRedeSocial.security.service;

import br.com.cwi.minhaRedeSocial.security.controller.response.DetalharUsuarioResponse;
import br.com.cwi.minhaRedeSocial.security.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.cwi.minhaRedeSocial.security.mapper.DetalharUsuarioMapper.toResponse;

@Service
public class DetalharUsuarioService {

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public DetalharUsuarioResponse detalhar() {

        Usuario usuario = usuarioAutenticadoService.get();

        return toResponse(usuario);
    }
}
