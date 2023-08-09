package com.example.validado.backend.ideia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IdeiaRepository extends JpaRepository<IdeiaModel, Long> {
    @Query(value = " SELECT i.id, u.nome AS nomeUsuario, i.titulo AS titulo, i.descricao AS descricao, " +
            " (SELECT COUNT(*) FROM vinculo_upvote_usuarios_ideias v WHERE v.id_ideia = i.id " +
            " AND v.deletado = false AND v.usuario_curtiu = true) AS upvotes " +
            " FROM ideia i " +
            " INNER JOIN usuarios u ON u.id = i.id_usuario " +
            " WHERE i.descricao ILIKE %:termoBusca% OR i.titulo ILIKE %:termoBusca% " +
            " GROUP BY u.nome, i.titulo, i.descricao, i.data_atualizacao, i.id " +
            " ORDER BY i.data_atualizacao ", nativeQuery = true)
    List<IdeiaGridDTO> encontrarIdeiasGrid(@Param("termoBusca") String termoBusca);

    @Query(value = " SELECT i.id, u.nome AS nomeUsuario, i.titulo AS titulo, i.descricao AS descricao, " +
            " (SELECT COUNT(*) FROM vinculo_upvote_usuarios_ideias v WHERE v.id_ideia = i.id " +
            " AND v.deletado = false AND v.usuario_curtiu = true) AS upvotes " +
            " FROM ideia i " +
            " INNER JOIN usuarios u ON u.id = i.id_usuario " +
            " WHERE i.id = :idIdeia " +
            " GROUP BY u.nome, i.titulo, i.descricao, i.data_atualizacao, i.id " +
            " ORDER BY i.data_atualizacao ", nativeQuery = true)
    Optional<IdeiaGridDTO> encontrarIdeiasGridPorId(@Param("idIdeia") Long idIdeia);

    @Query(value = " SELECT i.id, u.nome AS nomeUsuario, i.titulo AS titulo, i.descricao AS descricao, " +
            " (SELECT COUNT(*) FROM vinculo_upvote_usuarios_ideias v WHERE v.id_ideia = i.id " +
            " AND v.deletado = false AND v.usuario_curtiu = true) AS upvotes " +
            " FROM ideia i " +
            " INNER JOIN usuarios u ON u.id = i.id_usuario " +
            " GROUP BY u.nome, i.titulo, i.descricao, i.data_atualizacao, i.id " +
            " ORDER BY upvotes " +
            " LIMIT 5 ", nativeQuery = true)
    List<IdeiaGridDTO> encontrarTopIdeias();
}
