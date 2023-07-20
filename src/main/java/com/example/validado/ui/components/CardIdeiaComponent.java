package com.example.validado.ui.components;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.Text;

public class CardIdeiaComponent extends VerticalLayout {
    public CardIdeiaComponent(String nomeUsuario, int quantidadeEstrelas, String texto) {
        setWidth("20%");
        setHeightFull();
        HorizontalLayout estrelasLayout = new HorizontalLayout();

        for (int i = 0; i < quantidadeEstrelas; i++) {
            Div estrela = new Div();
            estrela.setText("★");
            estrela.getStyle().set("color", "#FFC247")
                .set("font-weight", "bold");
            estrelasLayout.add(estrela);
        }

        Div textoDiv = new Div(new Text(texto));
        Div nomeUsuarioDiv = new Div(new Text(nomeUsuario));
        nomeUsuarioDiv.getStyle().set("font-weight", "bold");

        getStyle().set("background-color", "#FFFFFF")
            .set("border-radius", "30px");
        setMaxWidth("209px");
        add(estrelasLayout, textoDiv, nomeUsuarioDiv);
    }
}
