package com.example.validado.ui;

import com.example.validado.ui.components.CabecalhoUsuarioLogado;
import com.example.validado.ui.components.ListagemPesquisa;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("pesquisar")
public class TelaBusca extends VerticalLayout {

    private CabecalhoUsuarioLogado cabecalhoUsuarioLogado;
    private ListagemPesquisa listaPesquisa;

    public TelaBusca(){
        this.cabecalhoUsuarioLogado = new CabecalhoUsuarioLogado();
        this.listaPesquisa = new ListagemPesquisa();
        add(cabecalhoUsuarioLogado, listaPesquisa);
    }
}
