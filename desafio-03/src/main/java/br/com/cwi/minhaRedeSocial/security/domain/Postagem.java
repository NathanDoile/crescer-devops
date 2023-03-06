package br.com.cwi.minhaRedeSocial.security.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Postagem {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonIgnore
    private Usuario usuarioPostagem;

    private LocalDate dataPostagem;

    @Enumerated(STRING)
    private Privacidade privacidade;

    private String imagem;

    private String mensagem;

    private boolean ativo;

    @OneToMany(mappedBy = "postagemCurtida")
    private List<Curtida> curtidas = new ArrayList<>();

    @OneToMany(mappedBy = "postagemComentada")
    private List<Comentario> comentario = new ArrayList<>();
}
