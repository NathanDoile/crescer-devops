package br.com.cwi.minhaRedeSocial.security.service;

import br.com.cwi.minhaRedeSocial.security.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@Service
public class ValidarEmailService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public void validar(String email) {

        if(usuarioRepository.existsByEmail(email)){
            throw new ResponseStatusException(BAD_REQUEST, "Esse e-mail já foi usado!");
        }
    }
}
