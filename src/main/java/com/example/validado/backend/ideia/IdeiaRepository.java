package com.example.validado.backend.ideia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IdeiaRepository extends JpaRepository<IdeiaModel, Long> {
    @Query(value = "SELECT " +
            " (SELECT u.nome FROM usuarios u WHERE u.id = i.id_usuario) AS nomeUsuario " +
            " i.titulo AS titulo, " +
            " i.descricao AS descricao, " +
            " (COUNT(SELECT v.id FROM vinculo_upvote_usuarios_ideias v WHERE v.id_ideia = i.id)) AS upvotes " +
            " FROM ideia i " +
            " ORDER BY i.dataAtualizacao ", nativeQuery = true)
    List<IdeiaGridDTO> encontrarIdeiasGrid();
}
