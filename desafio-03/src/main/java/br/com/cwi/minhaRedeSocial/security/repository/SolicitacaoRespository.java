package br.com.cwi.minhaRedeSocial.security.repository;

import br.com.cwi.minhaRedeSocial.security.domain.SolicitacaoAmizade;
import br.com.cwi.minhaRedeSocial.security.domain.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitacaoRespository extends JpaRepository<SolicitacaoAmizade, Long> {

    Page<SolicitacaoAmizade> findAllByStatusAndUsuarioSolicitadoId(Status status, Long usuarioSolicitadoId,
                                                                            Pageable pageable);
}
