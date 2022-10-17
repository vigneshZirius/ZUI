package com.zstyles.application.views.about;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.zstyles.application.components.appnav.FloatingComponent;
import com.zstyles.application.views.MainLayout;

@PageTitle("Floating Component")
@Route(value = "floating-component", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class AboutView extends VerticalLayout {

  Div moreItem = new Div();

  public AboutView() {
    setSpacing(false);

    Dialog dialog = new Dialog();
    dialog.setHeaderTitle("New employee");
    Button cancelButton = new Button("Cancel", e -> dialog.close());
    dialog.getFooter().add(cancelButton);

    moreItem.addClassName("more-item");
    for (int i = 0; i < 3; i++) {
      Label lbl = new Label("Option" + 1);
      moreItem.add(lbl);
    }

    TextField textField = new TextField();
    textField.addClassName("some");
    textField.setPlaceholder("Enter something...");
    FloatingComponent txtFC = new FloatingComponent(textField, "bg-none", createInfo(), "float-icon");

    Label lbl = new Label(
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.");
    lbl.add(moreItem);
    FloatingComponent lblFC = new FloatingComponent(lbl, createEllipsis(), createEllipsis());

    Label lbl2 = new Label(
        "Label with custom class for multile icons");
    lbl2.add(moreItem);
    FloatingComponent multipleIconWithCustomClass = new FloatingComponent(lbl, "icon-wrapper", createicon(), createEllipsis());
    multipleIconWithCustomClass.add(moreItem);
    Label hoverMe = new Label(
        "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.");
    FloatingComponent chatContent = new FloatingComponent(hoverMe);

    FloatingComponent userDetails = new FloatingComponent(userCard(), createEllipsis());

    add(chatContent, lblFC, txtFC, userDetails, multipleIconWithCustomClass);
    setSizeFull();
  }

  public Icon createEllipsis() {
    Icon icon = VaadinIcon.ELLIPSIS_DOTS_V.create();
    icon.addClickListener(
        e -> {
          if (moreItem.hasClassName("show")) {
            moreItem.removeClassName("show");
          } else {
            moreItem.addClassName("show");
          }
        });
    return icon;
  }

  public Icon createicon() {
    Icon icon = VaadinIcon.DOWNLOAD.create();
    icon.addClickListener(
        e -> {
          if (moreItem.hasClassName("show")) {
            moreItem.removeClassName("show");
          } else {
            moreItem.addClassName("show");
          }
        });
    return icon;
  }

  
  public Icon createInfo() {
    Icon icon = VaadinIcon.INFO.create();
    icon.addClickListener(
        e -> {
          if (moreItem.hasClassName("show")) {
            moreItem.removeClassName("show");
          } else {
            moreItem.addClassName("show");
          }
        });
    return icon;
  }


  public Div userCard() {
    Div div = new Div();
    div.addClassName("user-details");
    Div wrapper = new Div();
    wrapper.addClassName("wrapper");
    Image img = new Image("images/empty-plant.png", "placeholder plant");
    Label lbl = new Label("Username");
    Paragraph p = new Paragraph("Description of the above details...");
    wrapper.add(lbl, p);
    div.add(img, wrapper);
    return div;
  }

  public void test() {
  }
}
