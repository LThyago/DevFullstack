package com.example.validado.ui;

import com.example.validado.backend.cadastro.CadastroService;
import com.example.validado.ui.components.CabecalhoUsuarioDeslogado;
import com.example.validado.ui.components.CabecalhoUsuarioLogado;
import com.example.validado.ui.components.CorpoTelaInicial;
import com.example.validado.ui.components.Login;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route(value = "")
@PageTitle("Validado")
public class TelaInicial extends VerticalLayout {

    CabecalhoUsuarioDeslogado cabecalhoUsuarioDeslogado;
    CabecalhoUsuarioLogado cabecalhoUsuarioLogado;
    CorpoTelaInicial corpoTelaInicial;
    boolean usuarioLogado = false;

    private CadastroService cadastroService; // Injetar o CadastroService aqui

    @Autowired
       public TelaInicial(CadastroService cadastroService){
        this.cadastroService = cadastroService;
        this.corpoTelaInicial = new CorpoTelaInicial();
        if(usuarioLogado){
            this.cabecalhoUsuarioLogado = new CabecalhoUsuarioLogado();
            add(cabecalhoUsuarioLogado, corpoTelaInicial);
        }else{
            this.cabecalhoUsuarioDeslogado = new CabecalhoUsuarioDeslogado(cadastroService);
            add(cabecalhoUsuarioDeslogado, corpoTelaInicial);
        }
        setHeightFull();
        getStyle().set("border", "none");
        getStyle().set("padding", "0");
    }
}
