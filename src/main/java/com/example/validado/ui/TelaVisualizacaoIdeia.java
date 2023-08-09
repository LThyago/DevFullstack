package com.example.validado.ui;

import com.example.validado.backend.cadastro.UserService;
import com.example.validado.backend.ideia.IdeiaGridDTO;
import com.example.validado.backend.ideia.IdeiaService;
import com.example.validado.backend.vinculoempresaideia.VinculoEmpresaIdeiaService;
import com.example.validado.backend.vinculoupvoteideia.VinculoUpvoteIdeiaService;
import com.example.validado.ui.components.CabecalhoUsuarioDeslogado;
import com.example.validado.ui.components.CabecalhoUsuarioLogado;
import com.example.validado.ui.components.CorpoVisualizacaoIdeia;
import com.vaadin.flow.component.UI;
//import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.*;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;
//import com.vaadin.flow.server.VaadinSession;
@RolesAllowed({"EMPRESA", "USER"})
@Route(value = "ideia")
@PageTitle("Validado")
public class TelaVisualizacaoIdeia extends VerticalLayout implements BeforeEnterObserver {

    private CabecalhoUsuarioDeslogado cabecalhoUsuarioDeslogado;
    private CabecalhoUsuarioLogado cabecalhoUsuarioLogado;
    private CorpoVisualizacaoIdeia corpoVisualizacaoIdeia;
    private boolean usuarioLogado = false;

    private UserService cadastroService;
    private IdeiaService ideiaService;
    private VinculoUpvoteIdeiaService vinculoUpvoteIdeiaService;
    private VinculoEmpresaIdeiaService vinculoEmpresaIdeiaService;

    @Autowired
       public TelaVisualizacaoIdeia(UserService cadastroService, IdeiaService ideiaService,
                                    VinculoUpvoteIdeiaService vinculoUpvoteIdeiaService,
                                    VinculoEmpresaIdeiaService vinculoEmpresaIdeiaService){
        this.vinculoEmpresaIdeiaService = vinculoEmpresaIdeiaService;
        this.vinculoUpvoteIdeiaService = vinculoUpvoteIdeiaService;
        this.cadastroService = cadastroService;
        this.ideiaService = ideiaService;
        this.corpoVisualizacaoIdeia = new CorpoVisualizacaoIdeia();
        this.cabecalhoUsuarioLogado = new CabecalhoUsuarioLogado();

        setHeightFull();
        getStyle().set("border", "none");
        getStyle().set("padding", "0");
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
                        ideia.getDescricao(), ideia.getUpvotes().toString(),
                        vinculoUpvoteIdeiaService.getQuantidadeEstrelasIdeia(ideia.getId()).toString(),
                        ideia.getNomeUsuario(), ideia.getId(), this.vinculoEmpresaIdeiaService);
            }
        }
        add(cabecalhoUsuarioLogado, corpoVisualizacaoIdeia);
    }
}


