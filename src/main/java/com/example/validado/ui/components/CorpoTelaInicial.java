package com.example.validado.ui.components;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;


public class CorpoTelaInicial extends VerticalLayout {

    HorizontalLayout tituloCorpo;
    HorizontalLayout carrosselIdeias;
    HorizontalLayout footerParcerias;

    public CorpoTelaInicial(){
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
        CardIdeiaComponent cardExemplo =
            new CardIdeiaComponent("John Doe",
                5, "Eu gostei muito da aplicação, ajudou muito nas tarefas diárias. Nota 10!!!");
        CardIdeiaComponent cardExemplo2 =
                new CardIdeiaComponent("John Doe",
                        5, "Eu gostei muito da aplicação, ajudou muito nas tarefas diárias. Nota 10!!!");

        CardIdeiaComponent cardExemplo3 =
                new CardIdeiaComponent("John Doe",
                        5, "Eu gostei muito da aplicação, ajudou muito nas tarefas diárias. Nota 10!!!");

        CardIdeiaComponent cardExemplo4 =
                new CardIdeiaComponent("John Doe",
                        5, "Eu gostei muito da aplicação, ajudou muito nas tarefas diárias. Nota 10!!!");

        CardIdeiaComponent cardExemplo5 =
                new CardIdeiaComponent("John Doe",
                        5, "Eu gostei muito da aplicação, ajudou muito nas tarefas diárias. Nota 10!!!");

        HorizontalLayout ideiasPaginaInicial = new HorizontalLayout(cardExemplo, cardExemplo2, cardExemplo3, cardExemplo4, cardExemplo5);
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
