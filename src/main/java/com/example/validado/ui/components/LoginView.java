package com.example.validado.ui.components;

import com.example.validado.backend.cadastro.AuthService;
import com.example.validado.ui.TelaInicial;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import jakarta.annotation.security.PermitAll;

@PermitAll
@Route("login")
@PageTitle("Login")
public class LoginView extends VerticalLayout {
    private VerticalLayout formularioLogin;
    private Image logo;
    private TextField campoLogin;
    private PasswordField campoSenha;
    private Anchor textoEsqueciSenha;
    private Button botaoLogin;
    private HorizontalLayout textoAjuda;
    private AuthService authService;

    public LoginView(AuthService authService) {
        this.setId("login-view");
        this.setSizeFull();
        this.getStyle().set("background-image", "url('/fundo.png')")
                .set("background-size", "cover").set("position", "absolute").set("top", "0").set("left", "0").set("display", "flex").set("justify-content", "center").set("align-items", "center");
        this.formularioLogin = this.getFormularioLogin();

        Div backgroundDiv = new Div(); //div criada apenas para evento click
        backgroundDiv.getStyle()
                .set("width", "100%")
                .set("height", "100%")
                .set("position", "absolute")
                .set("top", "0")
                .set("z-index","9")
                .set("left", "0");
        backgroundDiv.addClickListener(event -> {
            UI.getCurrent().navigate("");
        });
        Button botaoLogin = new Button("Login", (event) -> {
            try {
                authService.authenticate(this.campoLogin.getValue(), this.campoSenha.getValue());
                String nomeUsuario = this.campoLogin.getValue();
                VaadinSession.getCurrent().setAttribute("nomeUsuario", nomeUsuario);
                UI.getCurrent().navigate("");
                TelaInicial telaInicial = (TelaInicial)UI.getCurrent().getChildren().filter((component) -> {
                    return component instanceof TelaInicial;
                }).map((component) -> {
                    return (TelaInicial)component;
                }).findFirst().orElse((TelaInicial) null);
                if (telaInicial != null) {
                    telaInicial.updateHeader(true);
                }
            } catch (AuthService.AuthException var5) {
                Notification.show("Wrong credentials.");
            }

        });
        botaoLogin.getStyle().set("background-color", "#4200FF").set("color", "#FFFFFF").set("position", "absolute").set("bottom", "80px").set("z-index","10");
        this.add(new Component[]{backgroundDiv, this.getFormularioLogin()});
        this.add(new Component[]{botaoLogin});
    }

    private VerticalLayout getFormularioLogin() {
        VerticalLayout formularioLogin = new VerticalLayout(new Component[]{this.getLogo(), this.getCampoLogin(), this.getCampoSenha(), this.getAjuda()});
        formularioLogin.getStyle().set("background-color", "#FFFFFF").set("z-index","10");
        formularioLogin.setWidth("557px");
        formularioLogin.setHeight("758px");
        formularioLogin.setAlignItems(Alignment.CENTER);
        formularioLogin.setJustifyContentMode(JustifyContentMode.CENTER);
        this.formularioLogin = formularioLogin;
        return this.formularioLogin;
    }

    private Image getLogo() {
        String caminhoImagem = "/logo.png";
        Image logo = new Image(caminhoImagem, "Logo Validado");
        logo.setMaxWidth("80px");
        this.logo = logo;
        return this.logo;
    }

    private TextField getCampoLogin() {
        TextField campoLogin = new TextField("Username");
        campoLogin.setWidthFull();
        this.campoLogin = campoLogin;
        return this.campoLogin;
    }

    private PasswordField getCampoSenha() {
        PasswordField campoSenha = new PasswordField("Senha");
        campoSenha.setWidthFull();
        this.campoSenha = campoSenha;
        return this.campoSenha;
    }

    private HorizontalLayout getAjuda() {
        Text textoAjuda = new Text("Não possui uma conta?");
        Anchor linkRegistro = new Anchor("", "Crie uma conta nova");
        HorizontalLayout layoutTextoAjuda = new HorizontalLayout(new Component[]{textoAjuda, linkRegistro});
        this.textoAjuda = layoutTextoAjuda;
        return this.textoAjuda;
    }
}
