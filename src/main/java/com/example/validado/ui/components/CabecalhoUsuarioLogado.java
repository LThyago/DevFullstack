package com.example.validado.ui.components;

import com.example.validado.ui.TelaInicial;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.server.VaadinSession;

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
        ComboBox<String> dropdownEmpresa = new ComboBox<>();
        String nomeUsuario = (String) VaadinSession.getCurrent().getAttribute("nomeUsuario");
        dropdownEmpresa.setItems(nomeUsuario, "Perfil", "Logout");
        dropdownEmpresa.setValue(nomeUsuario);

        dropdownEmpresa.addValueChangeListener(event -> {
            if("Logout".equals(event.getValue())) {
                openLogoutDialog();
                dropdownEmpresa.setValue(nomeUsuario);
            }
        });
        botaoPublicar.addClassName("botao-publicar");
        botaoPublicar.getStyle()
                .set("background-color", "#5048E5")
                .set("border-radius", "50px")
                .set("padding", "15px 30px")
                .set("box-shadow", "0px 4px 8px rgba(0, 0, 0, 0.1)")
                .set("margin", "10px")
                .set("color", "#FFFFFF");
        dropdownEmpresa.getElement().getStyle()
                .set("background-color", "#FFFFFF")
                .set("color", "#5048E5")
                .set("border-radius", "50px");
        dropdownEmpresa.setWidth("auto");
        HorizontalLayout layoutFerramentasUsuario = new HorizontalLayout(botaoPublicar, dropdownEmpresa);
        layoutFerramentasUsuario.setAlignItems(FlexComponent.Alignment.CENTER);
        layoutFerramentasUsuario.setSpacing(false);

        this.ferramentasUsuario = layoutFerramentasUsuario;

        return this.ferramentasUsuario;
    }

    private void openLogoutDialog() {
        Dialog confirmDialog = new Dialog();

        Text messageText = new Text("Você realmente quer sair?");
        Button confirmButton = new Button("Sim", event -> logout());
        Button cancelButton = new Button("Não", event -> confirmDialog.close());

        confirmDialog.add(new VerticalLayout(messageText, new HorizontalLayout(confirmButton, cancelButton)));
        confirmDialog.open();
    }

    private void logout() {
        VaadinSession.getCurrent().getSession().invalidate();
        UI.getCurrent().getPage().setLocation("/");

        TelaInicial telaInicial = (TelaInicial) UI.getCurrent().getChildren()
                .filter(component -> component instanceof TelaInicial)
                .findFirst()
                .orElse(null);

        if (telaInicial != null) {
            telaInicial.updateHeader(false);
        }
    }
}
