package com.zstyles.application.theme;

import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.shared.Registration;
import javax.persistence.metamodel.SetAttribute;
import javax.swing.event.DocumentEvent;
import javax.swing.text.html.HTML;

/**
 * @author erik@vaadin.com
 * @since 20.5.2021
 */
public class ThemeUtil extends HTML {

  public static final String THEME_ATTRIBUTE = "theme";

  public static void selectThemeVariant(ThemeVariant themeVariant) {
    VaadinSession.getCurrent().setAttribute(THEME_ATTRIBUTE, themeVariant);
    UI ui = UI.getCurrent();
    ui.getElement().setAttribute(THEME_ATTRIBUTE, themeVariant.getAttribute());
    ui
      .getPage()
      .executeJs("document.querySelector('html').setAttribute('theme', '" + themeVariant.getAttribute() + "')");
    ComponentUtil.fireEvent(ui, new ThemeVariantChangedEvent(ui, themeVariant));
  }

  public static ThemeVariant getCurrentThemeVariant() {
    ThemeVariant themeVariant = (ThemeVariant) VaadinSession.getCurrent().getAttribute(THEME_ATTRIBUTE);
    return themeVariant != null ? themeVariant : ThemeVariant.DAY;
  }

  public static Registration addThemeChangedListener(UI ui, ComponentEventListener<ThemeVariantChangedEvent> listener) {
    return ComponentUtil.addListener(ui, ThemeVariantChangedEvent.class, listener);
  }

  public static class ThemeVariantChangedEvent extends ComponentEvent<UI> {

    private final ThemeVariant themeVariant;

    public ThemeVariantChangedEvent(UI source, ThemeVariant themeVariant) {
      super(source, false);
      this.themeVariant = themeVariant;
    }

    public ThemeVariant getThemeVariant() {
      return themeVariant;
    }
  }
}
