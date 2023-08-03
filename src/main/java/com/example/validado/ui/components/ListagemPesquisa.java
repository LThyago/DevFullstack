package com.example.validado.ui.components;

import com.example.validado.backend.ideia.IdeiaGridDTO;
import com.example.validado.backend.ideia.IdeiaService;
import com.example.validado.backend.vinculoupvoteideia.VinculoUpvoteIdeiaService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
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

    public ListagemPesquisa(IdeiaService ideiaService){
        this.ideiaService = ideiaService;
        this.ideias = getIdeias();
        configureGrid();
        setSizeFull();
        add(this.grid);
    }

    private void configureGrid() {
        grid.addColumn(IdeiaGridDTO::getNomeUsuario).setHeader("Nome");
        grid.addColumn(IdeiaGridDTO::getTitulo).setHeader("Título");
        grid.addColumn(IdeiaGridDTO::getDescricao).setHeader("Descrição");
        grid.addColumn(IdeiaGridDTO::getUpvotes).setHeader("Upvotes");
        grid.setSelectionMode(Grid.SelectionMode.NONE);
        grid.setHeight("500px");
        grid.addItemClickListener(click -> {

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
