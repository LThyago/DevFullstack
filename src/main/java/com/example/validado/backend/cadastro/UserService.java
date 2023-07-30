package com.example.validado.backend.cadastro;

import lombok.RequiredArgsConstructor;
import org.vaadin.crudui.crud.CrudListener;
import java.util.Collection;

@org.springframework.stereotype.Service
@RequiredArgsConstructor

public class UserService implements CrudListener<User> {
    private final UserRepository repository;

    @Override
    public Collection<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User add(User cadastro) {
        cadastro.setRole(Role.USER);

        return repository.save(cadastro);
    }

    @Override
    public User update(User cadastro) {
        return repository.save(cadastro);
    }

    @Override
    public void delete(User cadastro) {
        repository.delete(cadastro);

    }

    public boolean existsByUser(String user) {
        return repository.existsByUsername(user);
    }

    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
