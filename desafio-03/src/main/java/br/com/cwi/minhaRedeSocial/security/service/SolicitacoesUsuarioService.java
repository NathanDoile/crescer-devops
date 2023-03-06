package br.com.cwi.minhaRedeSocial.security.service;

import br.com.cwi.minhaRedeSocial.security.domain.Status;
import br.com.cwi.minhaRedeSocial.security.controller.response.SolicitacoesUsuarioResponse;
import br.com.cwi.minhaRedeSocial.security.mapper.SolicitacoesUsuarioMapper;
import br.com.cwi.minhaRedeSocial.security.repository.SolicitacaoRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SolicitacoesUsuarioService {

    @Autowired
    private SolicitacaoRespository solicitacaoRespository;

    @Autowired
    private UsuarioAutenticadoService usuarioAutenticadoService;

    public Page<SolicitacoesUsuarioResponse> solicitacoes(Pageable pageable) {

        Long idUsuario = usuarioAutenticadoService.getId();

        return solicitacaoRespository
                .findAllByStatusAndUsuarioSolicitadoId(Status.PENDENTE, idUsuario, pageable)
                .map(SolicitacoesUsuarioMapper::toResponse);
    }
}
