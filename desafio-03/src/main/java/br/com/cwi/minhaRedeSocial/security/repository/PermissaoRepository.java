package br.com.cwi.minhaRedeSocial.security.repository;

import br.com.cwi.minhaRedeSocial.security.domain.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
}
