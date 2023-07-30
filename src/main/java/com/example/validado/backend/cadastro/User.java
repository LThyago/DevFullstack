package com.example.validado.backend.cadastro;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

@Entity
@Data

@Table(name = "usuarios")
public class User {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    private String username;
    private String email;
    private String passwordSalt;
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String username, String password, Role role) {

        this.username = username;

        this.role = Role.USER;

        this.passwordSalt = RandomStringUtils.random(32);

        this.passwordHash = DigestUtils.sha1Hex(password + passwordSalt);

    }
    public boolean checkPassword(String password) {

        return DigestUtils.sha1Hex(password + passwordSalt).equals(passwordHash);
    }

}
