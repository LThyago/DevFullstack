package com.example.validado.backend.vinculoempresaideia;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "vinculo_empresa_ideias")
public class VinculoEmpresaIdeiaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_usuario")
    private Long idUsuario;
    @Column(name = "id_ideia")
    private Long idIdeia;
    @Column(name = "situacao_vinculo")
    private Long situacaoVinculo;
    @Column(name = "deletado")
    private boolean deletado;
    @Column(name = "data_vinculo")
    private LocalDate dataVinculo;
}
