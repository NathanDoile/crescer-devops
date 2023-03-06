package br.com.cwi.minhaRedeSocial.security.mapper;

import br.com.cwi.minhaRedeSocial.security.domain.SolicitacaoAmizade;
import br.com.cwi.minhaRedeSocial.security.controller.response.SolicitacoesUsuarioResponse;

public class SolicitacoesUsuarioMapper {

    public static SolicitacoesUsuarioResponse toResponse(SolicitacaoAmizade solicitacaoAmizade) {

        return SolicitacoesUsuarioResponse
                .builder()
                .nomeUsuarioSolicitante(solicitacaoAmizade.getUsuarioSolicitante().getNomeCompleto())
                .imagemUsuarioSolicitante(solicitacaoAmizade.getUsuarioSolicitante().getImagemPerfil())
                .dataPedido(solicitacaoAmizade.getDataPedido())
                .build();
    }
}
