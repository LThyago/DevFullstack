package com.example.validado.ui.components;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;

public class CabecalhoUsuarioLogado extends HorizontalLayout{
    private Image logo;
    private HorizontalLayout barraPesquisa;
    private HorizontalLayout ferramentasUsuario;

    public CabecalhoUsuarioLogado(){
        add(getLogo(), getBarraPesquisa(), getFerramentasUsuario());
        setJustifyContentMode(FlexComponent.JustifyContentMode.BETWEEN);
        setAlignItems(FlexComponent.Alignment.CENTER);
        setWidthFull();
        setMaxHeight("70px");
        getStyle().set("padding", "3px");
    }

    private Image getLogo(){
        String caminhoImagem = "/logo.png";
        Image logo = new Image(caminhoImagem, "Logo Validado");
        logo.setMaxWidth("80px");
        this.logo = logo;
        return this.logo;
    }

    private HorizontalLayout getBarraPesquisa(){
        TextField campoBusca = new TextField();
        campoBusca.setPlaceholder("Pesquisar");
        campoBusca.setWidth("50%");
        Icon botaoPesquisa = new Icon(VaadinIcon.SEARCH);
        botaoPesquisa.getStyle().set("cursor", "pointer");
        campoBusca.setSuffixComponent(botaoPesquisa);
        botaoPesquisa.addClickListener(
                event -> {
                    String termoBusca = campoBusca.getValue();
                }
        );
        HorizontalLayout layoutBusca = new HorizontalLayout(campoBusca);
        layoutBusca.setWidthFull();
        layoutBusca.setAlignItems(FlexComponent.Alignment.CENTER);
        layoutBusca.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);
        this.barraPesquisa = layoutBusca;

        return this.barraPesquisa;
    }

    private HorizontalLayout getFerramentasUsuario(){

        Button botaoPublicar = new Button("Publicar");
        botaoPublicar.addClickListener(e -> {
            UI.getCurrent().navigate("publicar");
        });
        Button botaoNomeEmpresa = new Button("Nome da Empresa");
        botaoNomeEmpresa.addClickListener(e -> {
            UI.getCurrent().navigate("Nome da Empresa");
        });
        botaoPublicar.addClassName("botao-publicar");
        botaoPublicar.getStyle()
                .set("background-color", "#5048E5")
                .set("border-radius", "50px")
                .set("padding", "15px 30px")
                .set("box-shadow", "0px 4px 8px rgba(0, 0, 0, 0.1)")
                .set("margin", "10px")
                .set("color", "#FFFFFF");
        botaoNomeEmpresa.addClassName("botao-nome-usuario");
        botaoNomeEmpresa.getStyle()
                .set("background-color", "#FFFFFF")
                .set("border-radius", "50px")
                .set("padding", "15px 30px")
                .set("box-shadow", "0px 4px 8px rgba(0, 0, 0, 0.1)")
                .set("margin", "10px")
                .set("color", "#5533FF");

        HorizontalLayout layoutFerramentasUsuario = new HorizontalLayout(botaoPublicar, botaoNomeEmpresa);
        layoutFerramentasUsuario.setSpacing(false);

        this.ferramentasUsuario = layoutFerramentasUsuario;

        return this.ferramentasUsuario;
    }
}
