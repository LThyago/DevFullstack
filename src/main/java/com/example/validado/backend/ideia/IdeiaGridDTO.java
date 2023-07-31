package com.example.validado.backend.ideia;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IdeiaGridDTO {
    private String nomeUsuario;
    private String titulo;
    private String descricao;
    private Long upvotes;
}
