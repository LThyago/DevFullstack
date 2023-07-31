package com.example.validado.backend.ideia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdeiaService {

    @Autowired
    private IdeiaRepository repository;

    public List<IdeiaGridDTO> recuperarIdeiasGrid(){
        return repository.encontrarIdeiasGrid();
    }
}
