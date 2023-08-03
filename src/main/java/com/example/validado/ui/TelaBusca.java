package com.example.validado.ui;

import com.example.validado.backend.ideia.IdeiaService;
import com.example.validado.ui.components.CabecalhoUsuarioLogado;
import com.example.validado.ui.components.ListagemPesquisa;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@Route("pesquisar")
public class TelaBusca extends VerticalLayout{

    private CabecalhoUsuarioLogado cabecalhoUsuarioLogado;
    private ListagemPesquisa listaPesquisa;
    private IdeiaService ideiaService;
    private String termoBusca;

    @Autowired
    public TelaBusca(IdeiaService ideiaService){
        this.ideiaService = ideiaService;
        this.cabecalhoUsuarioLogado = new CabecalhoUsuarioLogado();
        this.listaPesquisa = new ListagemPesquisa(ideiaService);
        cabecalhoUsuarioLogado.addBuscaListener(event -> {
            listaPesquisa.atualizarGrid(event.getTermoBusca());
        });
        add(cabecalhoUsuarioLogado, listaPesquisa);
    }
}
