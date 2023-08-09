package com.example.validado.backend.vinculoupvoteideia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;

@Service
public class VinculoUpvoteIdeiaService {
    @Autowired
    private VinculoUpvoteIdeiaRepository vinculoUpvoteIdeiaRepository;

    public boolean usuarioCurtiuIdeia(Long idUsuario, Long idIdeia){
        if(Objects.nonNull(vinculoUpvoteIdeiaRepository.findFirstByIdUsuarioAndIdIdeia(idUsuario,
                idIdeia).orElse(null))){
            return true;
        }else{
            return false;
        }
    }

    public void salvarUpvote(Long idUsuario, Long idIdeia){
        vinculoUpvoteIdeiaRepository.save(VinculoUpvoteIdeiaModel.builder()
                .idUsuario(idUsuario)
                .idIdeia(idIdeia)
                .deletado(false)
                .dataVinculo(LocalDate.now())
                .tipoInteracao(1L).build());
    }

    public void salvarAcessoIdeia(Long idUsuario, Long idIdeia){
        vinculoUpvoteIdeiaRepository.save(VinculoUpvoteIdeiaModel.builder()
                .idUsuario(idUsuario)
                .idIdeia(idIdeia)
                .deletado(false)
                .dataVinculo(LocalDate.now())
                .tipoInteracao(0L).build());
    }
}
