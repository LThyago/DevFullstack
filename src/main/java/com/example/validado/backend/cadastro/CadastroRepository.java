package com.example.validado.backend.cadastro;

import org.springframework.data.jpa.repository.JpaRepository;


public interface CadastroRepository extends JpaRepository<Cadastro, Long> {

    boolean existsByUser(String user);

    boolean existsByEmail(String email);
}
