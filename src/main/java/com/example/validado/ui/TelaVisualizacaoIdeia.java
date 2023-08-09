package com.example.validado.ui;

import com.example.validado.backend.cadastro.UserService;
import com.example.validado.backend.ideia.IdeiaGridDTO;
import com.example.validado.backend.ideia.IdeiaService;
import com.example.validado.ui.components.CabecalhoUsuarioDeslogado;
import com.example.validado.ui.components.CabecalhoUsuarioLogado;
import com.example.validado.ui.components.CorpoVisualizacaoIdeia;
import com.vaadin.flow.component.UI;
//import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
//import com.vaadin.flow.server.VaadinSession;

@Route(value = "ideia")
@PageTitle("Validado")
public class TelaVisualizacaoIdeia extends VerticalLayout implements BeforeEnterObserver {

    private CabecalhoUsuarioDeslogado cabecalhoUsuarioDeslogado;
    private CabecalhoUsuarioLogado cabecalhoUsuarioLogado;
    private CorpoVisualizacaoIdeia corpoVisualizacaoIdeia;
    private boolean usuarioLogado = false;

    private UserService cadastroService;
    private IdeiaService ideiaService;

    @Autowired
       public TelaVisualizacaoIdeia(UserService cadastroService, IdeiaService ideiaService){
        this.cadastroService = cadastroService;
        this.ideiaService = ideiaService;
        this.corpoVisualizacaoIdeia = new CorpoVisualizacaoIdeia();
        this.cabecalhoUsuarioLogado = new CabecalhoUsuarioLogado();
        add(cabecalhoUsuarioLogado, corpoVisualizacaoIdeia);

        setHeightFull();
        getStyle().set("border", "none");
        getStyle().set("padding", "0");
    }


    public void updateHeader(boolean usuarioLogado) {
        this.removeAll(); // Remove todos os componentes existentes na tela
        this.usuarioLogado = usuarioLogado; // Atualiza o estado do usuário logado

        if (usuarioLogado) {
            this.cabecalhoUsuarioLogado = new CabecalhoUsuarioLogado();
            add(cabecalhoUsuarioLogado, corpoVisualizacaoIdeia);
        } else {
            this.cabecalhoUsuarioDeslogado = new CabecalhoUsuarioDeslogado(cadastroService);
            add(cabecalhoUsuarioDeslogado, corpoVisualizacaoIdeia);
        }
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent){
        QueryParameters queryParameters = beforeEnterEvent.getLocation().getQueryParameters();
        List<String> ids = queryParameters.getParameters().get("id");

        if(Objects.nonNull(ids) && !ids.isEmpty()){
            String id = ids.get(0);
            IdeiaGridDTO ideia = ideiaService.recuperarIdeiasPorId(id);
            if(Objects.nonNull(ideia)) {
                this.corpoVisualizacaoIdeia.popularTelaIdeia(ideia.getTitulo(),
                        ideia.getDescricao(), ideia.getUpvotes().toString(), "5", ideia.getNomeUsuario());
            }
        }
        add(cabecalhoUsuarioDeslogado, corpoVisualizacaoIdeia);
    }
}


