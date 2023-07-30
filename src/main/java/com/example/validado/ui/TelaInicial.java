package com.example.validado.ui;

import com.example.validado.ui.components.CabecalhoUsuarioDeslogado;
import com.example.validado.ui.components.CabecalhoUsuarioLogado;
import com.example.validado.ui.components.CorpoTelaInicial;
import com.example.validado.ui.components.Login;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "")
@PageTitle("Validado")
public class TelaInicial extends VerticalLayout {

    private CabecalhoUsuarioDeslogado cabecalhoUsuarioDeslogado;
    private CabecalhoUsuarioLogado cabecalhoUsuarioLogado;
    private CorpoTelaInicial corpoTelaInicial;
    private boolean usuarioLogado = false;

    public TelaInicial(){
        this.corpoTelaInicial = new CorpoTelaInicial();
        if(usuarioLogado){
            this.cabecalhoUsuarioLogado = new CabecalhoUsuarioLogado();
            add(cabecalhoUsuarioLogado, corpoTelaInicial);
        }else{
            this.cabecalhoUsuarioDeslogado = new CabecalhoUsuarioDeslogado();
            add(cabecalhoUsuarioDeslogado, corpoTelaInicial);
        }
        setHeightFull();
        getStyle().set("border", "none");
        getStyle().set("padding", "0");
    }
}
