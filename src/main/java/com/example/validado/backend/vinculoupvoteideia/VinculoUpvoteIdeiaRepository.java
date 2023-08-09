package com.example.validado.backend.vinculoupvoteideia;

import com.example.validado.backend.ideia.IdeiaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface VinculoUpvoteIdeiaRepository extends JpaRepository<VinculoUpvoteIdeiaModel, Long> {
    Optional<VinculoUpvoteIdeiaModel> findFirstByIdUsuarioAndIdIdeia(@Param("idUsuario") Long idUsuario,
                                                                     @Param("idIdeia") Long idIdeia);
}
