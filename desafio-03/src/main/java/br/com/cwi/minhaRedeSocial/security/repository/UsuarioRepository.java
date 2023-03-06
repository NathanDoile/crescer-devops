package br.com.cwi.minhaRedeSocial.security.repository;

import br.com.cwi.minhaRedeSocial.security.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    boolean existsByEmail(String email);

    Page<Usuario> findByNomeCompletoContainingIgnoreCaseOrEmailContainingIgnoreCase(String nomeCompleto, String email, Pageable pageable);

}
