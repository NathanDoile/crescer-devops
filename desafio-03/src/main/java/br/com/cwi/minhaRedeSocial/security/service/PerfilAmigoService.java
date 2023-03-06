package br.com.cwi.minhaRedeSocial.security.service;

import br.com.cwi.minhaRedeSocial.security.controller.response.PerfilAmigoResponse;
import br.com.cwi.minhaRedeSocial.security.domain.Usuario;
import br.com.cwi.minhaRedeSocial.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static br.com.cwi.minhaRedeSocial.security.mapper.PerfilAmigoMapper.toResponse;

@Service
public class PerfilAmigoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public PerfilAmigoResponse perfil(Long id) {

        Usuario entity = usuarioRepository.findById(id).get();

        return toResponse(entity);
    }
}
