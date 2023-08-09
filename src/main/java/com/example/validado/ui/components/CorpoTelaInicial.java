package com.example.validado.ui.components;

import com.example.validado.backend.ideia.IdeiaGridDTO;
import com.example.validado.backend.ideia.IdeiaService;
import com.example.validado.backend.vinculoupvoteideia.VinculoUpvoteIdeiaService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;

import java.util.List;


public class CorpoTelaInicial extends VerticalLayout {

    HorizontalLayout tituloCorpo;
    HorizontalLayout carrosselIdeias;
    HorizontalLayout footerParcerias;
    private IdeiaService ideiaService;
    private VinculoUpvoteIdeiaService vinculoUpvoteIdeiaService;
    List<IdeiaGridDTO> listaIdeias;

    public CorpoTelaInicial(IdeiaService ideiaService, VinculoUpvoteIdeiaService vinculoUpvoteIdeiaService){
        this.vinculoUpvoteIdeiaService = vinculoUpvoteIdeiaService;
        this.ideiaService = ideiaService;
        this.listaIdeias = ideiaService.encontrarMaisPopulares();
        getStyle().set("background", "linear-gradient(to bottom, #C270C3, #6E5598)");
        setHeightFull();
        setWidthFull();
        add(getTituloCorpo(), getCarrosselIdeias());
    }

    private HorizontalLayout getTituloCorpo(){
        Text textoIdeias = new Text("Veja algumas das ideias mais populares:");
        HorizontalLayout textoDiv = new HorizontalLayout(textoIdeias);

        textoDiv.getStyle().set("font-size", "36px")
            .set("font-weight", "800")
            .set("color", "#02033B")
            .set("position", "relative");

        textoDiv.setJustifyContentMode(JustifyContentMode.CENTER);
        this.tituloCorpo = textoDiv;
        return this.tituloCorpo;
    }

    private HorizontalLayout getCarrosselIdeias(){
        HorizontalLayout ideiasPaginaInicial = new HorizontalLayout();
        listaIdeias.forEach(ideia -> {
            ideiasPaginaInicial.add(new CardIdeiaComponent(ideia.getNomeUsuario(),
                    vinculoUpvoteIdeiaService.getQuantidadeEstrelasIdeia(ideia.getId()).intValue(),
                    ideia.getDescricao()));
        });
        ideiasPaginaInicial.getStyle().set("position", "relative")
                .set("border-left", "96px")
                .set("border-left", "96px")
                .set("overflow-x", "auto")
                .set("top", "50px");
        ideiasPaginaInicial.setMaxHeight("48%");
        ideiasPaginaInicial.setWidthFull();
        this.carrosselIdeias = ideiasPaginaInicial;
        return ideiasPaginaInicial;
    }


}
