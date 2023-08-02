# Validado

## O que é

Validado é uma rede social onde participantes podem sugerir e implementar ideias de negócio. 

Assuma o papel de cliente e descreva produtos e serviços que você gostaria de usar. Assuma o papel de empresa e construa as ideias de clientes. Ou assuma os dois papéis ao mesmo tempo.

## Tecnologias
- Java
- Vaadin
- Spring Boot
- Maven
- PostgreSQL
  
## Instalação e Uso

Para rodar este projeto localmente, siga os seguintes passos:

1. Clone o repositório em seu computador local usando `git clone`.

2. Instale o PostgreSQL, caso ainda não tenha, e crie um banco de dados com o nome `postgres`.

3. Atualize as propriedades de conexão com o banco de dados em `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
vaadin.whitelisted-packages=com.example.validado,com.vaadin,org.vaadin,com.example.application
ˋˋˋ
4. Abra o projeto no seu IDE favorito (recomendamos o IntelliJ IDEA).

5. Certifique-se de que as dependências Maven estão corretamente configuradas e instaladas.

6. Para iniciar o servidor, localize e execute a classe principal com o método main().

7. A aplicação deve estar rodando no endereço http://localhost:8080/.
