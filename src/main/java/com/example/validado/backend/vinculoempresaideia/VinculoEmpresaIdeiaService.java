package com.example.validado.backend.vinculoempresaideia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    }

    public void desvincular(Long idIdeia, Long idUsuario){

    }

}
