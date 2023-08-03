package com.example.validado.backend.ideia;

import com.example.validado.backend.cadastro.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Service
public class IdeiaService {

    @Autowired
    private IdeiaRepository repository;

    public List<IdeiaGridDTO> recuperarIdeiasGrid(String termoBusca){
        if(Objects.isNull(termoBusca)){
            termoBusca = "";
        }
        return repository.encontrarIdeiasGrid(termoBusca);
    }

    public void criarIdeia(String nomeIdeia, String descricaoIdeia, User usuario){
        IdeiaModel ideia = IdeiaModel.builder()
                .idUsuario(usuario.getId())
                .titulo(nomeIdeia)
                .descricao(descricaoIdeia)
                .deletado(false)
                .dataCriacao(LocalDateTime.now())
                .dataAtualizacao(LocalDateTime.now())
                .build();
        repository.save(ideia);
    }
}
