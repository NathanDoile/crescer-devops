package br.com.cwi.minhaRedeSocial.security.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolicitacoesUsuarioResponse {

    private String nomeUsuarioSolicitante;

    private String imagemUsuarioSolicitante;

    private LocalDate dataPedido;
}
