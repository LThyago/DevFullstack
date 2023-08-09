package com.example.validado.backend.vinculoupvoteideia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

@Service
public class VinculoUpvoteIdeiaService {
    @Autowired
    private VinculoUpvoteIdeiaRepository vinculoUpvoteIdeiaRepository;

    public boolean usuarioCurtiuIdeia(Long idUsuario, Long idIdeia){
        if(Objects.nonNull(vinculoUpvoteIdeiaRepository
                .findFirstByIdUsuarioAndIdIdeiaAndDeletadoIsFalseAndUsuarioCurtiuIsTrue(idUsuario,
                idIdeia).orElse(null))){
            return true;
        }else{
            return false;
        }
    }

    public boolean usuarioVisualizouIdeia(Long idUsuario, Long idIdeia){
        if(Objects.nonNull(vinculoUpvoteIdeiaRepository
                .findFirstByIdUsuarioAndIdIdeiaAndDeletadoIsFalseAndUsuarioCurtiuIsFalse(idUsuario,
                idIdeia).orElse(null))){
            return true;
        }else{
            return false;
        }
    }

    public Optional<VinculoUpvoteIdeiaModel> getIdeiaVisualizada(Long idUsuario, Long idIdeia){
        return vinculoUpvoteIdeiaRepository
                .findFirstByIdUsuarioAndIdIdeiaAndDeletadoIsFalseAndUsuarioCurtiuIsFalse(idUsuario,
                        idIdeia);
    }

    public Optional<VinculoUpvoteIdeiaModel> getIdeiaCurtida(Long idUsuario, Long idIdeia){
        return vinculoUpvoteIdeiaRepository
                .findFirstByIdUsuarioAndIdIdeiaAndDeletadoIsFalseAndUsuarioCurtiuIsTrue(idUsuario,
                        idIdeia);
    }

    public void salvarUpvote(Long idUsuario, Long idIdeia){
        if(!usuarioCurtiuIdeia(idUsuario, idIdeia)) {
            VinculoUpvoteIdeiaModel vinculoUpvoteIdeiaModel = getIdeiaVisualizada(idUsuario, idIdeia)
                    .orElse(VinculoUpvoteIdeiaModel.builder()
                    .idUsuario(idUsuario)
                    .idIdeia(idIdeia)
                    .deletado(false)
                    .dataVinculo(LocalDate.now())
                    .build());
            vinculoUpvoteIdeiaModel.setUsuarioCurtiu(true);
            vinculoUpvoteIdeiaRepository.save(vinculoUpvoteIdeiaModel);
        }else{
            VinculoUpvoteIdeiaModel vinculoUpvoteIdeiaModel = getIdeiaCurtida(idUsuario, idIdeia)
                    .orElse(null);
            if(Objects.nonNull(vinculoUpvoteIdeiaModel)) {
                vinculoUpvoteIdeiaModel.setUsuarioCurtiu(false);
                vinculoUpvoteIdeiaRepository.save(vinculoUpvoteIdeiaModel);
            }
        }
    }

    public void salvarAcessoIdeia(Long idUsuario, Long idIdeia){
        if(!usuarioVisualizouIdeia(idUsuario, idIdeia) && !usuarioCurtiuIdeia(idUsuario, idIdeia)) {
            vinculoUpvoteIdeiaRepository.save(VinculoUpvoteIdeiaModel.builder()
                    .idUsuario(idUsuario)
                    .idIdeia(idIdeia)
                    .deletado(false)
                    .dataVinculo(LocalDate.now())
                    .usuarioCurtiu(false).build());
        }
    }

    public Long getQuantidadeEstrelasIdeia(Long idIdeia){
        Long qtdVisualizacoes = vinculoUpvoteIdeiaRepository.findQuantidadeVisualizacoesIdeia(idIdeia);
        Long qtdCurtidas = vinculoUpvoteIdeiaRepository.findQuantidadeCurtidasIdeia(idIdeia);
        if(qtdVisualizacoes.equals(0L)){
            return 0L;
        }

        return ((qtdCurtidas*5)/qtdVisualizacoes);
    }
}
