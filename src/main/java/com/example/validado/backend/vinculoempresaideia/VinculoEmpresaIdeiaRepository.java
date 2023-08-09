package com.example.validado.backend.vinculoempresaideia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface VinculoEmpresaIdeiaRepository extends JpaRepository<VinculoEmpresaIdeiaModel, Long> {
    Optional<VinculoEmpresaIdeiaModel> findFirstByIdIdeiaAndDeletadoIsFalse(@Param("idIdeia") Long idIdeia);

    Optional<VinculoEmpresaIdeiaModel> findFirstByIdIdeiaAndIdUsuarioAndDeletadoIsFalse(@Param("idIdeia") Long idIdeia,
                                                                            @Param("idUsuario") Long idUsuario);
}
