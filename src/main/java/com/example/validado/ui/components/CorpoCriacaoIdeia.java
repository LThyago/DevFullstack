package com.example.validado.ui.components;

import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;


public class CorpoCriacaoIdeia extends VerticalLayout {

    HorizontalLayout footerParcerias;

    private HorizontalLayout layoutRow = new HorizontalLayout();
    private VerticalLayout layoutColumn2 = new VerticalLayout();
    private HorizontalLayout layoutRow2 = new HorizontalLayout();
    private VerticalLayout layoutColumn3 = new VerticalLayout();
    private TextField textField = new TextField();
    private TextField textField2 = new TextField();
    private VerticalLayout layoutColumn4 = new VerticalLayout();
    private Avatar avatar = new Avatar();
    private Hr hr = new Hr();
    private HorizontalLayout layoutRow3 = new HorizontalLayout();
    private TextArea textArea = new TextArea();
    private VerticalLayout layoutColumn6 = new VerticalLayout();
    private HorizontalLayout layoutRow6 = new HorizontalLayout();
    private HorizontalLayout layoutRow4 = new HorizontalLayout();
    private HorizontalLayout layoutRow7 = new HorizontalLayout();
    private HorizontalLayout layoutRow5 = new HorizontalLayout();
    private Button buttonPrimary = new Button();
    private Button buttonSecondary = new Button();
    private VerticalLayout layoutColumn5 = new VerticalLayout();
    private HorizontalLayout layoutRow8 = new HorizontalLayout();

    public CorpoCriacaoIdeia(){
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
        layoutColumn3.setWidth(null);
        textField.setLabel("Nome da ideia");
        textField.setWidthFull();
        textField2.setLabel("Resumo da ideia");
        textField2.setWidthFull();
        layoutColumn4.addClassName(Padding.XLARGE);
        layoutColumn4.setWidth(null);
        avatar.setName("Firstname Lastname");
        layoutRow3.setWidthFull();
        layoutRow3.addClassName(Gap.MEDIUM);
        layoutColumn2.setFlexGrow(1.0, layoutRow3);
        textArea.setLabel("Descrição da ideia");
        layoutRow3.setFlexGrow(1.0, textArea);
        layoutColumn6.addClassName(Padding.LARGE);
        layoutColumn6.setWidth(null);
        layoutRow6.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow6);
        layoutRow6.addClassName(Gap.MEDIUM);
        layoutRow4.setWidthFull();
        layoutColumn2.setFlexGrow(1.0, layoutRow4);
        layoutRow4.addClassName(Gap.MEDIUM);
        layoutRow7.setHeightFull();
        layoutRow7.addClassName(Gap.MEDIUM);
        layoutRow4.setFlexGrow(1.0, layoutRow7);
        layoutRow5.setHeightFull();
        layoutRow5.addClassName(Gap.MEDIUM);
        buttonPrimary.setText("Salvar");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        buttonSecondary.setText("Cancelar");
        layoutColumn5.addClassName(Gap.XLARGE);
        layoutColumn5.addClassName(Padding.XLARGE);
        layoutColumn5.setWidth(null);
        layoutRow8.addClassName(Gap.MEDIUM);
        layoutRow8.addClassName(Padding.SMALL);
        add(layoutRow);
        layoutRow.add(layoutColumn2);
        layoutColumn2.add(layoutRow2);
        layoutRow2.add(layoutColumn3);
        layoutColumn3.add(textField);
        layoutColumn3.add(textField2);
        layoutRow2.add(layoutColumn4);
        layoutColumn4.add(avatar);
        layoutColumn2.add(hr);
        layoutColumn2.add(layoutRow3);
        layoutRow3.add(textArea);
        layoutRow3.add(layoutColumn6);
        layoutColumn2.add(layoutRow6);
        layoutColumn2.add(layoutRow4);
        layoutRow4.add(layoutRow7);
        layoutRow4.add(layoutRow5);
        layoutRow5.add(buttonPrimary);
        layoutRow5.add(buttonSecondary);
        layoutRow.add(layoutColumn5);
        layoutColumn5.add(layoutRow8);
    }
}