package com.example.validado.backend.ideia;

import com.example.validado.backend.cadastro.Cadastro;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ideia")
public class IdeiaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @Column(name = "id_usuario")
    private Cadastro usuario;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "deletado")
    private boolean deletado;
    @Column(name = "data_criacao")
    private LocalTime dataCriacao;
    @Column(name = "data_atualizacao")
    private LocalTime dataAtualizacao;
}
