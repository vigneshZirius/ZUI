package com.zstyles.application.components.appnav;

import com.nimbusds.jose.shaded.json.JSONObject;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.textfield.TextField;
import java.util.ArrayList;

public class FloatingComponent extends Div {

  Div moreItem = new Div();

  public FloatingComponent(Component field, Component... icon) {
    this.add(field);
    this.add(icon);
    this.addClassName("floating-container");
  }

  public FloatingComponent(Component field) {
    Dialog dialog = new Dialog();
    dialog.setHeaderTitle("New employee");
    Button cancelButton = new Button("Cancel", e -> dialog.close());
    dialog.getFooter().add(cancelButton);

    this.add(field, createIconWrapper(), moreItem);
    this.addClassName("floating-container");
  }

  public Div createIconWrapper() {
    ArrayList<JSONObject> arrList = new ArrayList();
    for (int i = 0; i < 3; i++) {
      JSONObject obj = new JSONObject();
      obj.put("name", "vignes");
      obj.put("id", 1234);
      arrList.add(obj);
    }

    moreItem.addClassNames("more-item right-side");
    for (int i = 0; i < arrList.size(); i++) {
      Label lbl = new Label("some");
      moreItem.add(lbl);
    }

    Div iconWrapper = new Div();
    iconWrapper.addClassName("icon-wrapper");

    Icon icon = VaadinIcon.ELLIPSIS_DOTS_V.create();
    icon.addClassName("icon");
    icon.addClickListener(
      e -> {
        if (moreItem.hasClassName("show")) {
          moreItem.removeClassName("show");
        } else {
          moreItem.addClassName("show");
        }
      }
    );

    Icon upload = VaadinIcon.UPLOAD_ALT.create();
    upload.addClassName("icon");
    upload.addClickListener(
      e -> {
        if (moreItem.hasClassName("show")) {
          moreItem.removeClassName("show");
        } else {
          moreItem.addClassName("show");
        }
      }
    );
    iconWrapper.add(upload, icon);
    return iconWrapper;
  }
}
