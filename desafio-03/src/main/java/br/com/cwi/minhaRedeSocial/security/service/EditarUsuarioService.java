package br.com.cwi.minhaRedeSocial.security.service;

import br.com.cwi.minhaRedeSocial.security.controller.request.EditarUsuarioRequest;
import br.com.cwi.minhaRedeSocial.security.domain.Usuario;
import br.com.cwi.minhaRedeSocial.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EditarUsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    @Transactional
    public void editar(EditarUsuarioRequest request) {

        Usuario entity = usuarioAutenticadoService.get();
        entity.setNomeCompleto(request.getNomeCompleto());
        entity.setApelido(request.getApelido());
        entity.setImagemPerfil(request.getImagemPerfil());

        usuarioRepository.save(entity);
    }
}
