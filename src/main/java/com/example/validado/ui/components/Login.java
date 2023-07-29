package com.example.validado.ui.components;


import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.PasswordField;

public class Login extends Div {

    private VerticalLayout formularioLogin;
    private Image logo;
    private EmailField campoLogin;
    private PasswordField campoSenha;
    private Anchor textoEsqueciSenha;
    private Button botaoLogin;
    private HorizontalLayout textoAjuda;


    public Login(){
        setSizeFull();
        add(getFormularioLogin());
    }

    private VerticalLayout getFormularioLogin(){
        VerticalLayout formularioLogin = new VerticalLayout(getLogo(), getCampoLogin(), getTextoEsqueciSenha(), getCampoSenha(), getBotaoLogin(), getAjuda());
        this.formularioLogin = formularioLogin;
        return this.formularioLogin;
    }

    private Image getLogo(){
        String caminhoImagem = "/logo.png";
        Image logo = new Image(caminhoImagem, "Logo Validado");
        logo.setMaxWidth("80px");
        this.logo = logo;
        return this.logo;
    }

    private EmailField getCampoLogin(){
        EmailField campoLogin = new EmailField("Email");
        this.campoLogin = campoLogin;
        return this.campoLogin;
    }

    private Anchor getTextoEsqueciSenha(){
        Anchor esqueciSenha = new Anchor("<LINK_ESQUECI_SENHA>", "Esqueceu a Senha?");
        this.textoEsqueciSenha = esqueciSenha;
        return this.textoEsqueciSenha;
    }

    private PasswordField getCampoSenha(){
        PasswordField campoSenha = new PasswordField("Senha");
        this.campoSenha = campoSenha;
        return this.campoSenha;
    }

    private Button getBotaoLogin(){
        Button botaoLogin = new Button("Login");
        botaoLogin.getStyle().set("background-color", "#4200FF")
                .set("color", "#FFFFFF");
        this.botaoLogin = botaoLogin;
        return this.botaoLogin;
    }

    private HorizontalLayout getAjuda(){
        Text textoAjuda = new Text("Não possui uma conta?");
        Anchor linkRegistro = new Anchor("LINK_TELA_REGISTRO", "Crie uma conta nova");
        HorizontalLayout layoutTextoAjuda = new HorizontalLayout(textoAjuda, linkRegistro);
        this.textoAjuda = layoutTextoAjuda;
        return this.textoAjuda;
    }
}