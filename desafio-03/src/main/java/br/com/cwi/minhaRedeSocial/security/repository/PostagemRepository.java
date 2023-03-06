package br.com.cwi.minhaRedeSocial.security.repository;

import br.com.cwi.minhaRedeSocial.security.domain.Postagem;
import br.com.cwi.minhaRedeSocial.security.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {

    Page<Postagem> findAllByUsuarioPostagemAndAtivo(Usuario usuarioPostagem, boolean ativo, Pageable pageable);
}
