package com.example.validado.ui.components;

import com.example.validado.backend.ideia.IdeiaGridDTO;
import com.example.validado.backend.ideia.IdeiaService;
import com.example.validado.backend.vinculoupvoteideia.VinculoUpvoteIdeiaService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ListagemPesquisa extends VerticalLayout {

    private Grid<IdeiaGridDTO> grid = new Grid<>(IdeiaGridDTO.class);
    private IdeiaService ideiaService;
    private VinculoUpvoteIdeiaService vinculoUpvoteIdeiaService;

    public ListagemPesquisa(IdeiaService ideiaService){
        this.ideiaService = ideiaService;
        setSizeFull();
        configureGrid();
        add(this.grid);
    }

    private void configureGrid() {
        grid.setItems(getIdeias());

        grid.addColumn(IdeiaGridDTO::getNomeUsuario).setHeader("Nome");
        grid.addColumn(IdeiaGridDTO::getTitulo).setHeader("Título");
        grid.addColumn(IdeiaGridDTO::getDescricao).setHeader("Descrição");
        grid.addColumn(IdeiaGridDTO::getUpvotes).setHeader("Upvotes");
        grid.setSelectionMode(Grid.SelectionMode.NONE);
        grid.setHeight("500px");
    }

    private List<IdeiaGridDTO> getIdeias() {
        return ideiaService.recuperarIdeiasGrid();
    }
}
