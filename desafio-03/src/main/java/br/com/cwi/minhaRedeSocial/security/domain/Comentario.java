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
public class Comentario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_postagem")
    @JsonIgnore
    private Postagem postagemComentada;

    @ManyToOne
    @JoinColumn(name = "id_usuario_comentou")
    @JsonIgnore
    private Usuario usuarioComentou;

    private String mensagem;

    private String imagem;

    private boolean ativo;
}
