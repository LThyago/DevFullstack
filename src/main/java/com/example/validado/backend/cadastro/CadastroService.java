package com.example.validado.backend.cadastro;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.vaadin.crudui.crud.CrudListener;
import java.util.Collection;

@Service
@RequiredArgsConstructor

public class CadastroService implements CrudListener<Cadastro> {
    private final CadastroRepository repository;

    @Override
    public Collection<Cadastro> findAll() {
        return repository.findAll();
    }

    @Override
    public Cadastro add(Cadastro cadastro) {
        return repository.save(cadastro);
    }

    @Override
    public Cadastro update(Cadastro cadastro) {
        return repository.save(cadastro);
    }

    @Override
    public void delete(Cadastro cadastro) {
          repository.delete(cadastro);

    }

    public boolean existsByUser(String user) {
        return repository.existsByUser(user);
    }

    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

}
