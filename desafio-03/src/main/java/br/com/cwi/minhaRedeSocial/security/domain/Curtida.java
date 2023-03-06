package br.com.cwi.minhaRedeSocial.security.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Curtida {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_postagem")
    @JsonIgnore
    private Postagem postagemCurtida;

    @ManyToOne
    @JoinColumn(name = "id_usuario_curtiu")
    @JsonIgnore
    private Usuario usuarioCurtiu;

    private boolean ativo;
}
