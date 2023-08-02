package com.example.validado.ui;

import com.example.validado.backend.cadastro.UserService;
import com.example.validado.backend.ideia.IdeiaService;
import com.example.validado.ui.components.CabecalhoUsuarioDeslogado;
import com.example.validado.ui.components.CabecalhoUsuarioLogado;
import com.example.validado.ui.components.CorpoCriacaoIdeia;
import com.vaadin.flow.component.UI;
//import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
//import com.vaadin.flow.server.VaadinSession;

@Route(value = "criar-ideia")
@PageTitle("Validado")
public class TelaCriacaoIdeia extends VerticalLayout {

    private CabecalhoUsuarioDeslogado cabecalhoUsuarioDeslogado;
    private CabecalhoUsuarioLogado cabecalhoUsuarioLogado;
    private CorpoCriacaoIdeia corpoCriacaoIdeia;
    private boolean usuarioLogado = false;

    private UserService cadastroService;
    private IdeiaService ideiaService;

    @Autowired
       public TelaCriacaoIdeia(UserService cadastroService, IdeiaService ideiaService){
        this.cadastroService = cadastroService;
        this.corpoCriacaoIdeia = new CorpoCriacaoIdeia(ideiaService);
        this.cabecalhoUsuarioLogado = new CabecalhoUsuarioLogado();
        add(cabecalhoUsuarioLogado, corpoCriacaoIdeia);

        setHeightFull();
        getStyle().set("border", "none");
        getStyle().set("padding", "0");
    }

}

