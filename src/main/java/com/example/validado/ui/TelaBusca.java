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
import java.util.Objects;

@Route("pesquisar")
public class TelaBusca extends VerticalLayout implements BeforeEnterObserver{

    private CabecalhoUsuarioLogado cabecalhoUsuarioLogado;
    private ListagemPesquisa listaPesquisa;
    private IdeiaService ideiaService;
    private String termoBusca;

    @Autowired
    public TelaBusca(IdeiaService ideiaService){
        this.ideiaService = ideiaService;
        this.cabecalhoUsuarioLogado = new CabecalhoUsuarioLogado();
        this.listaPesquisa = new ListagemPesquisa(ideiaService);
        add(cabecalhoUsuarioLogado, listaPesquisa);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent){
        QueryParameters queryParameters = beforeEnterEvent.getLocation().getQueryParameters();
        List<String> termosBusca = queryParameters.getParameters().get("termoBusca");
        if(Objects.nonNull(termosBusca) && !termosBusca.isEmpty()){
            this.termoBusca = termosBusca.get(0);
        }
        listaPesquisa.atualizarGrid(this.termoBusca);
    }
}
