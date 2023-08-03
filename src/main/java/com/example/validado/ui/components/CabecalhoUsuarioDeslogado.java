package com.example.validado.ui.components;

import com.example.validado.backend.cadastro.AuthService;
import com.example.validado.backend.cadastro.UserService;
import com.example.validado.ui.TelaInicial;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data

public class CabecalhoUsuarioDeslogado extends HorizontalLayout{

    private final UserService userService;

    private Image logo;
    private HorizontalLayout barraPesquisa;
    private HorizontalLayout loginRegistro;
    private Button loginButton;
    private Button registroButton;
    private Icon botaoPesquisa;
    private AuthService authService;

    public CabecalhoUsuarioDeslogado(UserService userService){
        this.userService = userService;
        add(getLogo(), getBarraPesquisa(), getLoginRegistro());
        setJustifyContentMode(JustifyContentMode.BETWEEN);
        setAlignItems(Alignment.CENTER);
        setWidthFull();
        setMaxHeight("70px");
        getStyle().set("padding", "3px");
    }

    private Image getLogo(){
        String caminhoImagem = "/logo.png";
        Image logo = new Image(caminhoImagem, "Logo Validado");
        logo.setMaxWidth("80px");
        this.logo = logo;
        return this.logo;
    }

    private HorizontalLayout getBarraPesquisa(){
        TextField campoBusca = new TextField();
        campoBusca.setPlaceholder("Pesquisar");
        campoBusca.setWidth("50%");
        Icon botaoPesquisa = new Icon(VaadinIcon.SEARCH);
        botaoPesquisa.getStyle().set("cursor", "pointer");
        botaoPesquisa.addClickListener(click -> UI.getCurrent().navigate("login"));
        campoBusca.setSuffixComponent(botaoPesquisa);
        HorizontalLayout layoutBusca = new HorizontalLayout(campoBusca);
        layoutBusca.setWidthFull();
        layoutBusca.setAlignItems(Alignment.CENTER);
        layoutBusca.setJustifyContentMode(JustifyContentMode.CENTER);
        this.botaoPesquisa = botaoPesquisa;
        this.barraPesquisa = layoutBusca;

        return this.barraPesquisa;
    }

    private HorizontalLayout getLoginRegistro(){
        Button botaoLogin = new Button("Login");
        Button botaoRegistro = new Button("Registrar-se");
        botaoLogin.addClassName("botao-login");
        botaoLogin.getStyle()
            .set("background-color", "#EBEBEB")
            .set("border-radius", "50px")
            .set("padding", "15px 30px")
            .set("box-shadow", "0px 4px 8px rgba(0, 0, 0, 0.1)")
            .set("margin", "10px")
            .set("color", "#000000");
        botaoRegistro.addClassName("botao-login");
        botaoRegistro.getStyle()
            .set("background-color", "#B76CBE")
            .set("border-radius", "50px")
            .set("padding", "15px 30px")
            .set("box-shadow", "0px 4px 8px rgba(0, 0, 0, 0.1)")
            .set("margin", "10px")
            .set("color", "#FFFFFF");

        // Criar o diálogo para o formulário de login
        /*Dialog dialogLogin = new Dialog();
        dialogLogin.add(new LoginView(authService));
        botaoLogin.addClickListener(event -> dialogLogin.open());*/
        botaoLogin.addClickListener(event -> UI.getCurrent().navigate("login"));
        Dialog dialogCadastro = new Dialog();
        dialogCadastro.add(new Cadastro(authService, userService));
        botaoRegistro.addClickListener(event -> dialogCadastro.open());


        HorizontalLayout layoutLoginRegistro = new HorizontalLayout(botaoLogin, botaoRegistro);
        layoutLoginRegistro.setSpacing(false);
        this.loginButton = botaoLogin;
        this.registroButton = botaoRegistro;
        this.loginRegistro = layoutLoginRegistro;

        return this.loginRegistro;
    }

}
