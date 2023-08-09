package com.example.validado.backend.vinculoupvoteideia;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "vinculo_upvote_usuarios_ideias")
public class VinculoUpvoteIdeiaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_usuario")
    private Long idUsuario;
    @Column(name = "id_ideia")
    private Long idIdeia;
    @Column(name = "deletado")
    private boolean deletado;
    @Column(name = "data_vinculo")
    private LocalDate dataVinculo;
    @Column(name = "tipo_interacao")
    private Long tipoInteracao;
}
