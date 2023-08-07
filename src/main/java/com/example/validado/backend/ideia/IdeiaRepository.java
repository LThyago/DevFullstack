package com.example.validado.backend.ideia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IdeiaRepository extends JpaRepository<IdeiaModel, Long> {
    @Query(value = " SELECT i.id, u.nome AS nomeUsuario, i.titulo AS titulo, i.descricao AS descricao, " +
            " COUNT(v.id) AS upvotes " +
            " FROM ideia i " +
            " INNER JOIN usuarios u ON u.id = i.id_usuario " +
            " LEFT JOIN vinculo_upvote_usuarios_ideias v ON v.id_usuario = u.id " +
            " WHERE i.descricao ILIKE %:termoBusca% OR i.titulo ILIKE %:termoBusca% " +
            " GROUP BY u.nome, i.titulo, i.descricao, v.id, i.data_atualizacao, i.id " +
            " ORDER BY i.data_atualizacao ", nativeQuery = true)
    List<IdeiaGridDTO> encontrarIdeiasGrid(@Param("termoBusca") String termoBusca);

    @Query(value = " SELECT i.id, u.nome AS nomeUsuario, i.titulo AS titulo, i.descricao AS descricao, " +
            " COUNT(v.id) AS upvotes " +
            " FROM ideia i " +
            " INNER JOIN usuarios u ON u.id = i.id_usuario " +
            " LEFT JOIN vinculo_upvote_usuarios_ideias v ON v.id_usuario = u.id " +
            " WHERE i.id = :idIdeia " +
            " GROUP BY u.nome, i.titulo, i.descricao, v.id, i.data_atualizacao, i.id " +
            " ORDER BY i.data_atualizacao ", nativeQuery = true)
    Optional<IdeiaGridDTO> encontrarIdeiasGridPorId(@Param("idIdeia") Long idIdeia);
}
