package br.com.cwi.minhaRedeSocial.security.domain;

import br.com.cwi.minhaRedeSocial.security.domain.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id") @ToString(of = "id")
public class Amigo {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @MapsId("usuario_id")
    @JsonIgnore
    private Usuario usuario;

    @ManyToOne
    @MapsId("amigo_id")
    @JsonIgnore
    private Usuario amigo;

    private LocalDate dataDeAmizade;

    private boolean ativo;
}
