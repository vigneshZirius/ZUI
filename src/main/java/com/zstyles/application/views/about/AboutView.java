package com.zstyles.application.views.about;

import com.nimbusds.jose.shaded.json.JSONObject;
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
import java.util.ArrayList;

@PageTitle("Wrapper")
@Route(value = "about", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
public class AboutView extends VerticalLayout {

  Div moreItem = new Div();

  public AboutView() {
    setSpacing(false);
    ArrayList<JSONObject> arrList = new ArrayList();
    for (int i = 0; i < 2; i++) {
      JSONObject obj = new JSONObject();
      obj.put("Edit", "vignes");
      obj.put("id", 1234);
      arrList.add(obj);
    }

    moreItem.addClassName("more-item");
    for (int i = 0; i < arrList.size(); i++) {
      Label lbl = new Label("menus");
      moreItem.add(lbl);
    }

    TextField textField = new TextField("Text Field");
    textField.addClassName("some");

    Label lbl = new Label(
      "This place intentionally left empty. It’s a place where you can grow your own UI 🤗. This place intentionally left empty. It’s a place where you can grow your own UI 🤗🤗🤗"
    );
    lbl.add(moreItem);
    FloatingComponent lblFC = new FloatingComponent(lbl, createIcon(), createIcon());
    FloatingComponent txtFC = new FloatingComponent(textField);

    Label hoverMe = new Label(
      "This place intentionally left empty. It’s a place where you can grow your own UI 🤗. This place intentionally left empty. It’s a place where you can grow your own UI 🤗🤗🤗"
    );
    FloatingComponent chatContent = new FloatingComponent(hoverMe);
    add(chatContent, txtFC);

    FloatingComponent userDetails = new FloatingComponent(userCard(), createIcon());
    add(userDetails);
    setSizeFull();
  }

  public Icon createIcon() {
    Icon icon = VaadinIcon.ELLIPSIS_DOTS_V.create();
    icon.addClassName("float-icon");
    icon.addClickListener(
      e -> {
        if (moreItem.hasClassName("show")) {
          moreItem.removeClassName("show");
        } else {
          moreItem.addClassName("show");
        }
      }
    );
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

  public void test() {}
}
