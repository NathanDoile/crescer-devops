package br.com.cwi.minhaRedeSocial.security.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import java.time.LocalDate;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
public class SolicitacaoAmizade {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @MapsId("usuario_solicitado_id")
    @JsonIgnore
    private Usuario usuarioSolicitado;

    @ManyToOne
    @MapsId("usuario_solicitante_id")
    @JsonIgnore
    private Usuario usuarioSolicitante;

    private LocalDate dataPedido;

    @Enumerated(STRING)
    private Status status;
}
