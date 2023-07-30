package com.example.validado.ui.components;

import com.example.validado.backend.cadastro.AuthService;
import com.example.validado.backend.cadastro.Role;
import com.example.validado.backend.cadastro.UserService;
import com.example.validado.backend.cadastro.User;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.router.Route;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;


@Route("cadastro")
public class Cadastro extends Div {


    private UserService userService;
    private AuthService authService;

    private TextField nome;
    private TextField usuario;
    private EmailField email;
    private PasswordField senha;
    private PasswordField confirmeSenha;


    public  Cadastro(AuthService authService) {
        this.authService = authService;

        setSizeFull();

        Div div = new Div();
        div.getStyle().set("background-color", "#e8e3e3"); // Define a cor de fundo branca
        div.getStyle().set("padding", "25px"); // padding
        div.getStyle().set("position", "absolute"); // Define a posição absoluta
        div.getStyle().set("top", "50%"); // Define a posição verticalmente no centro
        div.getStyle().set("left", "50%"); // Define a posição horizontalmente no centro
        div.getStyle().set("transform", "translate(-50%, -50%)"); // Centraliza a div
        div.setWidth("450px"); // Define a largura
        div.setHeight("500px"); // Define a altura

        nome = new TextField("Nome");
        nome.setPlaceholder("Digite seu nome");

        usuario = new TextField("Usuário");
        usuario.setPlaceholder("Nome de Usuário");

        email = new EmailField("Email");
        email.setPlaceholder("example@email.com");
        email.setErrorMessage("Por favor entre com um endereço de email válido.");

        senha = new PasswordField("Senha");
        senha.setPlaceholder("Digite a senha");
        senha.setRequiredIndicatorVisible(true);
        senha.setMinLength(8);
        senha.setHelperText(
                "A senha deve ter pelo menos 8 caracteres. Tem que ter ao menos uma letra e um número.");
        senha.setPattern("^(?=.*[0-9])(?=.*[a-zA-Z]).{8}.*$");
        senha.setErrorMessage("Senha Inválida");

        confirmeSenha = new PasswordField("Confirme a senha");

        Button save = new Button("Registrar-se");

        Dialog dialogLogin = new Dialog();
        dialogLogin.add(new LoginView(authService));

        Button botaoLinkLogin = new Button("Já possui cadastro? Faça login aqui");
        botaoLinkLogin.addClickListener(event -> dialogLogin.open());

        HorizontalLayout linksLayout = new HorizontalLayout(botaoLinkLogin, save);
        linksLayout.setWidth("100%"); // Define a largura total do save
        linksLayout.getStyle().set("justify-content", "space-between");
        linksLayout.getStyle().set("margin-top", "15px");
        FormLayout formLayout = new FormLayout();
        formLayout.add(nome, usuario, email, senha, confirmeSenha);
        formLayout.setResponsiveSteps(new ResponsiveStep("0", 1));

        formLayout.add(linksLayout);

        div.add(formLayout);
        add(div);

        //Styles:

        nome.getStyle().set("font-size", "12px");
        usuario.getStyle().set("font-size", "12px");
        email.getStyle().set("font-size", "12px");
        senha.getStyle().set("font-size", "12px");
        confirmeSenha.getStyle().set("font-size", "12px");
        //link
        botaoLinkLogin.getStyle().set("font-size", "12px");
        botaoLinkLogin.getStyle().set("margin-top", "15px");// tentando alinhar com o botao
        //botão
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        save.getStyle().set("font-size", "12px");
        save.addThemeVariants(ButtonVariant.LUMO_SMALL);
        save.setAutofocus(true);

        //
        save.addClickListener(event -> {
            String senhaValue = senha.getValue();
            String confirmeSenhaValue = confirmeSenha.getValue();

            if (senhaValue.equals(confirmeSenhaValue)) {
                String nomeValue = nome.getValue();
                String usuarioValue = usuario.getValue();
                String emailValue = email.getValue();

                // Verificar se já existe um usuário com o mesmo nome de usuário ou email
                boolean usuarioExistente = userService.existsByUser(usuarioValue);
                boolean emailExistente = userService.existsByEmail(emailValue);

                if (!usuarioExistente && !emailExistente) {
                    // Gera um novo valor aleatório para o sal
                    String passwordSalt = RandomStringUtils.random(32);

                    // Gera o hash da senha usando o sal gerado aleatoriamente
                    String passwordHash = DigestUtils.sha1Hex(senhaValue + passwordSalt);

                    // Cria o objeto User e define os valores dos campos
                    User cadastro = new User();
                    cadastro.setNome(nomeValue);
                    cadastro.setUsername(usuarioValue);
                    cadastro.setEmail(emailValue);
                    cadastro.setPasswordSalt(passwordSalt);
                    cadastro.setPasswordHash(passwordHash);
                    cadastro.setRole(Role.USER);
                    User savedCadastro = userService.add(cadastro);

                    if (savedCadastro != null) {
                        Notification.show("Usuário registrado com sucesso!", 3000, Notification.Position.MIDDLE);
                        //clearForm();
                        authService.register(usuarioValue, senhaValue);
                    } else {
                        Notification.show("Erro ao registrar o usuário", 3000, Notification.Position.MIDDLE);
                    }
                } else {
                    if (usuarioExistente) {
                        Notification.show("Já existe um usuário com o mesmo nome de usuário", 3000, Notification.Position.MIDDLE);
                    } else {
                        Notification.show("Já existe um usuário com o mesmo email", 3000, Notification.Position.MIDDLE);
                    }
                }
            } else {
                Notification.show("As senhas não correspondem", 3000, Notification.Position.MIDDLE);
            }
        });
        add(div);
    }
    private void clearForm() {
        nome.clear();
        usuario.clear();
        email.clear();
        senha.clear();
        confirmeSenha.clear();
    }
}


