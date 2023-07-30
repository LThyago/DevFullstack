package com.example.validado.backend.cadastro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User getByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    User findByEmail(String email);


}
