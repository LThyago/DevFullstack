package com.example.validado.ui;

import com.example.validado.backend.cadastro.UserService;
import com.example.validado.ui.components.CabecalhoUsuarioDeslogado;
import com.example.validado.ui.components.CabecalhoUsuarioLogado;
import com.example.validado.ui.components.CorpoTelaInicial;
import com.vaadin.flow.component.UI;
//import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
//import com.vaadin.flow.server.VaadinSession;

@Route(value = "")
@PageTitle("Validado")
public class TelaInicial extends VerticalLayout {

    CabecalhoUsuarioDeslogado cabecalhoUsuarioDeslogado;
    CabecalhoUsuarioLogado cabecalhoUsuarioLogado;
    CorpoTelaInicial corpoTelaInicial;
    boolean usuarioLogado = false;

    private UserService cadastroService;

    @Autowired
       public TelaInicial(UserService cadastroService){
        this.cadastroService = cadastroService;
        this.corpoTelaInicial = new CorpoTelaInicial();

        if (usuarioLogado) {
            this.cabecalhoUsuarioLogado = new CabecalhoUsuarioLogado();

                UI.getCurrent().navigate("");
                add(cabecalhoUsuarioLogado, corpoTelaInicial);
            } else {

            this.cabecalhoUsuarioDeslogado = new CabecalhoUsuarioDeslogado(cadastroService);

            add(cabecalhoUsuarioDeslogado, corpoTelaInicial);
        }
        setHeightFull();
        getStyle().set("border", "none");
        getStyle().set("padding", "0");
    }


    public void updateHeader(boolean usuarioLogado) {
        this.removeAll(); // Remove todos os componentes existentes na tela
        this.usuarioLogado = usuarioLogado; // Atualiza o estado do usuário logado

        if (usuarioLogado) {
            this.cabecalhoUsuarioLogado = new CabecalhoUsuarioLogado();
            add(cabecalhoUsuarioLogado, corpoTelaInicial);
        } else {
            this.cabecalhoUsuarioDeslogado = new CabecalhoUsuarioDeslogado(cadastroService);
            add(cabecalhoUsuarioDeslogado, corpoTelaInicial);
        }
    }
}


