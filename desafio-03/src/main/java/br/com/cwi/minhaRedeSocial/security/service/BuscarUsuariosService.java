package br.com.cwi.minhaRedeSocial.security.service;

import br.com.cwi.minhaRedeSocial.security.controller.response.BuscarUsuariosResponse;
import br.com.cwi.minhaRedeSocial.security.mapper.BuscarUsuariosMapper;
import br.com.cwi.minhaRedeSocial.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BuscarUsuariosService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Page<BuscarUsuariosResponse> buscar(String texto, Pageable pageable) {

        return usuarioRepository
                .findByNomeCompletoContainingIgnoreCaseOrEmailContainingIgnoreCase(texto, texto, pageable)
                .map(BuscarUsuariosMapper::toResponse);
    }
}
