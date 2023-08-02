package com.example.validado.ui.components;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;


public class CorpoVisualizacaoIdeia extends VerticalLayout {

    HorizontalLayout footerParcerias;

    private HorizontalLayout layoutRow = new HorizontalLayout();
    private VerticalLayout layoutColumn2 = new VerticalLayout();
    private HorizontalLayout layoutRow2 = new HorizontalLayout();
    private VerticalLayout layoutColumn3 = new VerticalLayout();
    private H3 h3 = new H3();
    private Paragraph textSmall = new Paragraph();
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
        h3.setText("Gadget para Facilitar a Limpeza de Espaços pequenos");
        textSmall.setText(
                "Gostaria de um Gadget que facilitasse o dia a dia na limpeza de espaços muito pequenos de forma precisa.");
        textSmall.getStyle().set("font-size", "var(--lumo-font-size-xs)");
        layoutColumn4.addClassName(Padding.XLARGE);
        layoutColumn4.setWidth(null);
        avatar.setName("Firstname Lastname");
        layoutRow3.setWidthFull();
        layoutRow3.addClassName(Gap.MEDIUM);
        layoutColumn2.setFlexGrow(1.0, layoutRow3);
        textSmall2.setText(
                "Gostaria de um Gadget que facilitasse o dia a dia na limpeza de espaços muito pequenos de forma precisa. Precisa ser um Gadget fácil de limpar, para que sua reutilização seja prática.");
        textSmall2.getStyle().set("font-size", "var(--lumo-font-size-xs)");
        layoutColumn5.addClassName(Padding.SMALL);
        layoutColumn5.setWidth(null);
        layoutRow4.addClassName(Gap.MEDIUM);
        layoutRow4.addClassName(Padding.SMALL);
        icon.getElement().setAttribute("icon", "lumo:user");
        textMedium.setText("5.0");
        textMedium.getStyle().set("font-size", "var(--lumo-font-size-m)");
        textMedium2.setText("318 Upvotes");
        textMedium2.getStyle().set("font-size", "var(--lumo-font-size-m)");
        buttonPrimary.setText("Selecionar Ideia");
        buttonPrimary.setWidthFull();
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        add(layoutRow);
        layoutRow.add(layoutColumn2);
        layoutColumn2.add(layoutRow2);
        layoutRow2.add(layoutColumn3);
        layoutColumn3.add(h3);
        layoutColumn3.add(textSmall);
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
}
