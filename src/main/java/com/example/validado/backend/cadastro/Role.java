package com.example.validado.backend.cadastro;

public enum Role {
        USER("Usuário"),
        EMPRESA("Empresa");

        private final String displayName;

        Role(String displayName) {
                this.displayName = displayName;
        }

        public String getDisplayName() {
                return displayName;
        }
}

