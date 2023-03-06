package br.com.cwi.minhaRedeSocial.security.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter @Setter @EqualsAndHashCode(of = "id") @ToString(of = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String nomeCompleto;

    private String email;

    private String apelido;

    private LocalDate dataNascimento;

    private String senha;

    private String imagemPerfil;

    private String seriePreferida;

    private boolean ativo;

    @OneToMany(mappedBy = "usuarioPermissao", cascade = ALL, fetch = FetchType.EAGER)
    private List<Permissao> permissoes = new ArrayList<>();

    @OneToMany(mappedBy = "usuario", cascade = ALL, orphanRemoval = true)
    private List<Amigo> amigos = new ArrayList<>();

    @OneToMany(mappedBy = "usuarioSolicitado", cascade = ALL, orphanRemoval = true)
    private List<SolicitacaoAmizade> solicitacoes = new ArrayList<>();

    @OneToMany(mappedBy = "usuarioPostagem")
    private List<Postagem> postagens = new ArrayList<>();

    @OneToMany(mappedBy = "usuarioCurtiu")
    private List<Curtida> curtidas = new ArrayList<>();

    @OneToMany(mappedBy = "usuarioComentou")
    private List<Comentario> comentarios = new ArrayList<>();

    public void adicionarPermissao(Permissao permissao) {
        this.permissoes.add(permissao);
        permissao.setUsuarioPermissao(this);
    }

    public void adicionarPostagem(Postagem postagem){
        this.postagens.add(postagem);
        postagem.setUsuarioPostagem(this);
    }
}
