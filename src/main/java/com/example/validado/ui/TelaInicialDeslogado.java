package com.example.validado.ui;

import com.example.validado.ui.components.CabecalhoUsuarioDeslogado;
import com.example.validado.ui.components.CorpoTelaInicial;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value = "")
@PageTitle("Validado")
public class TelaInicialDeslogado extends VerticalLayout {

    CabecalhoUsuarioDeslogado cabecalho;
    CorpoTelaInicial corpoTelaInicial;

    public TelaInicialDeslogado(){
        this.cabecalho = new CabecalhoUsuarioDeslogado();
        this.corpoTelaInicial = new CorpoTelaInicial();
        add(cabecalho, corpoTelaInicial);
        setHeightFull();
        getStyle().set("border", "none");
        getStyle().set("padding", "0");
    }



}
