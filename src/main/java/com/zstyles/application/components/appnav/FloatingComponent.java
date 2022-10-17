package com.zstyles.application.components.appnav;

import com.nimbusds.jose.shaded.json.JSONObject;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import java.util.ArrayList;

public class FloatingComponent extends Div {
  Div moreItem = new Div();

  // wrapper for multiple icons
  public FloatingComponent(Component field, Component... icon) {
    Div iconWrapper = new Div();
    iconWrapper.addClassName("icon-wrapper");
    for (Component component : icon) {
      component.getElement().setAttribute("class", "icon");
      iconWrapper.add(icon);
    }
    this.add(field, iconWrapper);
    this.addClassName("floating-container");
  }

  // wrapper for multiple icons with custom class
  public FloatingComponent(Component field, String iconWrapperClassName, Component... icon) {
    Div iconWrapper = new Div();
    iconWrapper.addClassName(iconWrapperClassName);
    for (Component component : icon) {
      component.getElement().setAttribute("class", "icon");
      iconWrapper.add(icon);
    }
    this.add(field, iconWrapper);
    this.addClassName("floating-container");
  }

  // wrapper for single icon
  public FloatingComponent(Component field, Component icon) {
    icon.getElement().setAttribute("class", "float-icon");
    this.add(field, icon);
    this.addClassName("floating-container");
  }

  // wrapper for single icon with container classname
  public FloatingComponent(Component field, String containerClsName, Component icon) {
    icon.getElement().setAttribute("class", "float-icon");
    this.add(field, icon);
    this.addClassNames("floating-container", containerClsName);
  }

  // wrapper for single icon with custom class
  public FloatingComponent(Component field, Component icon, String iconClassName) {
    icon.getElement().setAttribute("class", iconClassName);
    this.add(field, icon);
    this.addClassName("floating-container");
  }

  // wrapper for single icon with dynamic container class and icon class name
  public FloatingComponent(Component field, String containerClsName, Component icon, String iconClassName) {
    icon.getElement().setAttribute("class", iconClassName);
    this.add(field, icon);
    this.addClassNames("floating-container", containerClsName);
  }

  // wrapper to add default icon
  public FloatingComponent(Component field) {
    this.add(field, defaultIcons(), moreItem);
    this.addClassName("floating-container");
  }

  public Div defaultIcons() {
    moreItem.addClassNames("more-item right-side");
    for (int i = 0; i < 3; i++) {
      Label lbl = new Label("Option " + (i + 1));
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
        });

    Icon upload = VaadinIcon.UPLOAD_ALT.create();
    upload.addClassName("icon");
    upload.addClickListener(
        e -> {
          if (moreItem.hasClassName("show")) {
            moreItem.removeClassName("show");
          } else {
            moreItem.addClassName("show");
          }
        });
    iconWrapper.add(upload, icon);
    return iconWrapper;
  }

}
