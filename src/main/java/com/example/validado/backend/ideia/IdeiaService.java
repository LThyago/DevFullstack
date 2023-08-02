package com.example.validado.backend.ideia;

import com.example.validado.backend.cadastro.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class IdeiaService {

    @Autowired
    private IdeiaRepository repository;

    public List<IdeiaGridDTO> recuperarIdeiasGrid(){
        return repository.encontrarIdeiasGrid();
    }

    public void criarIdeia(String nomeIdeia, String descricaoIdeia, User usuario){
        IdeiaModel ideia = IdeiaModel.builder()
                .idUsuario(1L)
                .titulo(nomeIdeia)
                .descricao(descricaoIdeia)
                .deletado(false)
                .dataCriacao(LocalDateTime.now())
                .dataAtualizacao(LocalDateTime.now())
                .build();
        repository.save(ideia);
    }
}
