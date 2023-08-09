package com.example.validado.backend.vinculoempresaideia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;

@Service
public class VinculoEmpresaIdeiaService {
    @Autowired
    private VinculoEmpresaIdeiaRepository vinculoEmpresaIdeiaRepository;

    public boolean verificaIdeiaVinculadaEmpresa(Long idIdeia){
        if(Objects.nonNull(vinculoEmpresaIdeiaRepository.findFirstByIdIdeiaAndDeletadoIsFalse(idIdeia)
                .orElse(null))){
            return true;
        }else{
            return false;
        }
    }

    public boolean verificaRelacaoEmpresaIdeia(Long idIdeia, Long idUsuario){
        if(Objects.nonNull(vinculoEmpresaIdeiaRepository.findFirstByIdIdeiaAndIdUsuarioAndDeletadoIsFalse(idIdeia,
                idUsuario).orElse(null))){
            return true;
        }else{
            return false;
        }
    }

    public void vincular(Long idIdeia, Long idUsuario){
        VinculoEmpresaIdeiaModel vinculoEmpresaIdeiaModel = vinculoEmpresaIdeiaRepository
                .findFirstByIdIdeiaAndIdUsuario(idIdeia, idUsuario)
                .orElse(VinculoEmpresaIdeiaModel.builder()
                        .idIdeia(idIdeia)
                        .idUsuario(idUsuario)
                        .situacaoVinculo(1L)
                        .dataVinculo(LocalDate.now()).build());
        vinculoEmpresaIdeiaModel.setDeletado(false);
        vinculoEmpresaIdeiaRepository.save(vinculoEmpresaIdeiaModel);
    }

    public void desvincular(Long idIdeia, Long idUsuario){
        vinculoEmpresaIdeiaRepository.findFirstByIdIdeiaAndIdUsuarioAndDeletadoIsFalse(idIdeia, idUsuario)
                .ifPresent(vinculo -> {
                    vinculo.setDeletado(true);
                    vinculo.setSituacaoVinculo(0L);
                    vinculoEmpresaIdeiaRepository.save(vinculo);
                });
    }

}
