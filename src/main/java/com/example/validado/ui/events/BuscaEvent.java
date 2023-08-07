package com.example.validado.ui.events;

import com.example.validado.ui.components.CabecalhoUsuarioLogado;
import com.vaadin.flow.component.ComponentEvent;
import lombok.Getter;

@Getter
public class BuscaEvent extends ComponentEvent<CabecalhoUsuarioLogado> {
    private String termoBusca;
    public BuscaEvent(CabecalhoUsuarioLogado origem, boolean fromClient, String termoBusca){
        super(origem, fromClient);
        this.termoBusca = termoBusca;
    }
}
