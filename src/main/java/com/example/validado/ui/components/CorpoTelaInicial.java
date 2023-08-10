package com.example.validado.ui.components;

import com.example.validado.backend.cadastro.User;
import com.example.validado.backend.ideia.IdeiaGridDTO;
import com.example.validado.backend.ideia.IdeiaService;
import com.example.validado.backend.vinculoupvoteideia.VinculoUpvoteIdeiaService;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.VaadinSession;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.stream.Collectors;


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

    private HorizontalLayout getCarrosselIdeias() {
        HorizontalLayout ideiasPaginaInicial = new HorizontalLayout();
        listaIdeias.forEach(ideia -> {
            CardIdeiaComponent cardIdeia = new CardIdeiaComponent(ideia.getNomeUsuario(),
                    vinculoUpvoteIdeiaService.getQuantidadeEstrelasIdeia(ideia.getId()).intValue(),
                    ideia.getDescricao());

            cardIdeia.addClickListener(event -> {
                if (isLoggedIn()) {
                    navigateToDetalhesIdeia(ideia.getId());
                } else {
                    navigateToLogin();
                }
            });

            ideiasPaginaInicial.add(cardIdeia);
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

    private boolean isLoggedIn() {
        return VaadinSession.getCurrent().getAttribute(User.class) != null;
    }

    private void navigateToDetalhesIdeia(long ideiaId) {
        MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        queryParams.add("id", String.valueOf(ideiaId));

        String queryString = queryParams.entrySet().stream()
                .map(entry -> entry.getKey() + "=" + entry.getValue().get(0))
                .collect(Collectors.joining("&"));

        String detalhesIdeiaUrl = "ideia?" + queryString;

        UI.getCurrent().navigate(detalhesIdeiaUrl);
    }

    private void navigateToLogin() {
        UI.getCurrent().navigate("login");
    }


}
