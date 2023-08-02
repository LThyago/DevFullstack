package com.example.validado.ui;

import com.example.validado.backend.ideia.IdeiaService;
import com.example.validado.ui.components.CabecalhoUsuarioLogado;
import com.example.validado.ui.components.ListagemPesquisa;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("pesquisar")
public class TelaBusca extends VerticalLayout {

    private CabecalhoUsuarioLogado cabecalhoUsuarioLogado;
    private ListagemPesquisa listaPesquisa;
    private IdeiaService ideiaService;

    @Autowired
    public TelaBusca(IdeiaService ideiaService){
        this.ideiaService = ideiaService;
        this.cabecalhoUsuarioLogado = new CabecalhoUsuarioLogado();
        this.listaPesquisa = new ListagemPesquisa(ideiaService);
        add(cabecalhoUsuarioLogado, listaPesquisa);
    }
}
