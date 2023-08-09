package com.example.validado.ui.components;

import com.example.validado.backend.cadastro.Role;
import com.example.validado.backend.cadastro.User;
import com.example.validado.backend.vinculoempresaideia.VinculoEmpresaIdeiaService;
import com.example.validado.backend.vinculoupvoteideia.VinculoUpvoteIdeiaService;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;


public class CorpoVisualizacaoIdeia extends VerticalLayout {

    HorizontalLayout footerParcerias;

    private HorizontalLayout layoutRow = new HorizontalLayout();
    private VerticalLayout layoutColumn2 = new VerticalLayout();
    private HorizontalLayout layoutRow2 = new HorizontalLayout();
    private VerticalLayout layoutColumn3 = new VerticalLayout();
    private H3 h3 = new H3();
    private VerticalLayout layoutColumn4 = new VerticalLayout();
    private Avatar avatar = new Avatar();
    private Hr hr = new Hr();
    private HorizontalLayout layoutRow3 = new HorizontalLayout();
    private Paragraph textSmall2 = new Paragraph();
    private VerticalLayout layoutColumn5 = new VerticalLayout();
    private HorizontalLayout layoutRow4 = new HorizontalLayout();
    private Icon icon = new Icon();
    private Paragraph textMedium = new Paragraph();
    private Paragraph textMedium2 = new Paragraph();
    private Button buttonPrimary = new Button();
    private Hr hr2 = new Hr();

    private VinculoUpvoteIdeiaService vinculoUpvoteIdeiaService;

    public CorpoVisualizacaoIdeia(){
        setWidthFull();
        layoutRow.setWidthFull();
        setFlexGrow(1.0, layoutRow);
        layoutRow.addClassName(Gap.MEDIUM);
        layoutRow.setFlexGrow(1.0, layoutColumn2);
        layoutColumn2.setWidth(null);
        layoutRow2.setWidthFull();
        layoutRow2.addClassName(Gap.MEDIUM);
        layoutColumn2.setFlexGrow(1.0, layoutRow2);
        layoutColumn3.addClassName(Padding.XSMALL);
        layoutRow2.setFlexGrow(1.0, layoutColumn3);
        layoutColumn3.setHeightFull();
        layoutColumn3.setWidth(null);
        layoutColumn4.addClassName(Padding.XLARGE);
        layoutColumn4.setWidth(null);
        layoutRow3.setWidthFull();
        layoutRow3.addClassName(Gap.MEDIUM);
        layoutColumn2.setFlexGrow(1.0, layoutRow3);
        textSmall2.getStyle().set("font-size", "var(--lumo-font-size-xs)");
        layoutColumn5.addClassName(Padding.SMALL);
        layoutColumn5.setWidth(null);
        layoutRow4.addClassName(Gap.MEDIUM);
        layoutRow4.addClassName(Padding.SMALL);
        icon.getElement().setAttribute("icon", "lumo:user");
        textMedium.getStyle().set("font-size", "var(--lumo-font-size-m)");
        textMedium2.getStyle().set("font-size", "var(--lumo-font-size-m)");
        add(layoutRow);
        layoutRow.add(layoutColumn2);
        layoutColumn2.add(layoutRow2);
        layoutRow2.add(layoutColumn3);
        layoutColumn3.add(h3);
        layoutRow2.add(layoutColumn4);
        layoutColumn4.add(avatar);
        layoutColumn2.add(hr);
        layoutColumn2.add(layoutRow3);
        layoutRow3.add(textSmall2);
        layoutRow.add(layoutColumn5);
        layoutColumn5.add(layoutRow4);
        layoutRow4.add(icon);
        layoutRow4.add(textMedium);
        layoutRow4.add(textMedium2);
        layoutColumn5.add(buttonPrimary);

        layoutColumn5.add(hr2);
    }

    public void popularTelaIdeia(String titulo, String descricao, String upvotes, String classificacao,
                                 String nomeUsuario, Long idIdeia,
                                 VinculoEmpresaIdeiaService vinculoEmpresaIdeiaService){
        h3.setText(titulo);
        textSmall2.setText(descricao);
        textMedium2.setText(upvotes + " Upvotes");
        textMedium.setText(classificacao + ".0");
        avatar.setName(nomeUsuario);

        if(VaadinSession.getCurrent().getAttribute(User.class).getRole().equals(Role.EMPRESA)) {
            if(!vinculoEmpresaIdeiaService.verificaIdeiaVinculadaEmpresa(idIdeia)) {
                buttonPrimary.setText("Selecionar Ideia");
                buttonPrimary.setWidthFull();
                buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
                buttonPrimary.addClickListener(click -> {
                    vinculoEmpresaIdeiaService.vincular(idIdeia, VaadinSession.getCurrent()
                            .getAttribute(User.class).getId());
                });
            }else{
                if(vinculoEmpresaIdeiaService
                        .verificaRelacaoEmpresaIdeia(idIdeia, VaadinSession.getCurrent()
                                .getAttribute(User.class).getId())){
                    buttonPrimary.setText("Cancelar Seleção");
                    buttonPrimary.setWidthFull();
                    buttonPrimary.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
                    buttonPrimary.addClickListener(click -> {
                        vinculoEmpresaIdeiaService.desvincular(idIdeia, VaadinSession.getCurrent()
                                .getAttribute(User.class).getId());
                    });
                }else{
                    buttonPrimary.setText("Ideia já selecionada");
                    buttonPrimary.setWidthFull();
                    buttonPrimary.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
                }

            }
        }else{
            buttonPrimary.setText("Não disponível");
            buttonPrimary.setWidthFull();
            buttonPrimary.addThemeVariants(ButtonVariant.LUMO_TERTIARY);
        }

    }
}
