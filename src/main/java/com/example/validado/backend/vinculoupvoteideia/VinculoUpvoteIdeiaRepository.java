package com.example.validado.backend.vinculoupvoteideia;

import com.example.validado.backend.ideia.IdeiaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface VinculoUpvoteIdeiaRepository extends JpaRepository<VinculoUpvoteIdeiaModel, Long> {
    Optional<VinculoUpvoteIdeiaModel> findFirstByIdUsuarioAndIdIdeiaAndDeletadoIsFalseAndUsuarioCurtiuIsTrue(@Param("idUsuario") Long idUsuario,
                                                                     @Param("idIdeia") Long idIdeia);
    Optional<VinculoUpvoteIdeiaModel> findFirstByIdUsuarioAndIdIdeiaAndDeletadoIsFalseAndUsuarioCurtiuIsFalse(@Param("idUsuario") Long idUsuario,
                                                                                                             @Param("idIdeia") Long idIdeia);
    @Query(value = " SELECT COUNT(*) AS quantidade " +
            " FROM vinculo_upvote_usuarios_ideias v " +
            " WHERE v.id_ideia = :idIdeia AND v.deletado = false ", nativeQuery = true)
    Long findQuantidadeVisualizacoesIdeia(@Param("idIdeia") Long idIdeia);

    @Query(value = " SELECT COUNT(*) AS quantidade " +
            " FROM vinculo_upvote_usuarios_ideias v " +
            " WHERE v.id_ideia = :idIdeia AND v.deletado = false AND v.usuario_curtiu = true ", nativeQuery = true)
    Long findQuantidadeCurtidasIdeia(@Param("idIdeia") Long idIdeia);
}
