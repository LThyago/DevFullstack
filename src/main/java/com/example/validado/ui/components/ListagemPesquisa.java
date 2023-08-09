package com.example.validado.ui.components;

import com.example.validado.backend.cadastro.User;
import com.example.validado.backend.cadastro.UserService;
import com.example.validado.backend.ideia.IdeiaGridDTO;
import com.example.validado.backend.ideia.IdeiaService;
import com.example.validado.backend.vinculoupvoteideia.VinculoUpvoteIdeiaService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.VaadinSession;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Objects;

@Setter
public class ListagemPesquisa extends VerticalLayout {

    private Grid<IdeiaGridDTO> grid = new Grid<>(IdeiaGridDTO.class);
    private IdeiaService ideiaService;
    private VinculoUpvoteIdeiaService vinculoUpvoteIdeiaService;
    private String termoBusca;
    private List<IdeiaGridDTO> ideias;

    public ListagemPesquisa(IdeiaService ideiaService, VinculoUpvoteIdeiaService vinculoUpvoteIdeiaService){
        this.vinculoUpvoteIdeiaService = vinculoUpvoteIdeiaService;
        this.ideiaService = ideiaService;
        this.ideias = getIdeias();
        configureGrid();
        setSizeFull();
        add(this.grid);
    }

    private void configureGrid() {
        grid.removeAllColumns();
        grid.addColumn(IdeiaGridDTO::getNomeUsuario).setHeader("Nome");
        grid.addColumn(IdeiaGridDTO::getTitulo).setHeader("Título");
        grid.addColumn(IdeiaGridDTO::getDescricao).setHeader("Descrição");
        grid.addColumn(IdeiaGridDTO::getUpvotes).setHeader("Upvotes");
        grid.addComponentColumn(ideia -> {
            Icon heartIcon = VaadinIcon.HEART.create();
            if(vinculoUpvoteIdeiaService.usuarioCurtiuIdeia(VaadinSession.getCurrent()
                    .getAttribute(User.class).getId(), ideia.getId())){
                heartIcon.setColor("purple");
            }
            heartIcon.addClickListener(click -> {
                vinculoUpvoteIdeiaService.salvarUpvote(VaadinSession.getCurrent()
                        .getAttribute(User.class).getId(), ideia.getId());
            });
            return heartIcon;
        });
        grid.setSelectionMode(Grid.SelectionMode.SINGLE);
        grid.setHeight("500px");
        grid.addItemClickListener(click -> {
            vinculoUpvoteIdeiaService.salvarAcessoIdeia(VaadinSession.getCurrent()
                    .getAttribute(User.class).getId(), click.getItem().getId());
            UI.getCurrent().navigate("ideia?id="+click.getItem().getId());

        });
    }

    private List<IdeiaGridDTO> getIdeias() {
        return ideiaService.recuperarIdeiasGrid(this.termoBusca);
    }

    public void atualizarGrid(String termoBusca){
        this.termoBusca = termoBusca;
        this.ideias = getIdeias();
        grid.setItems(this.ideias);
    }
}
