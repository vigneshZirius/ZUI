package com.zstyles.application.views;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.select.Select;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.zstyles.application.components.appnav.AppNav;
import com.zstyles.application.components.appnav.AppNavItem;
import com.zstyles.application.components.appnav.FloatingComponent;
import com.zstyles.application.theme.ThemeSelector;
import com.zstyles.application.theme.ThemeUtil;
import com.zstyles.application.views.about.AboutView;
import com.zstyles.application.views.cardlist.CardListView;
import com.zstyles.application.views.checkoutform.CheckoutFormView;
import com.zstyles.application.views.imagelist.ImageListView;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

  private H2 viewTitle;

  public MainLayout() {
    setPrimarySection(Section.DRAWER);
    addDrawerContent();
    addHeaderContent(new ThemeSelector());
    setDefaultTheme();
  }

  private void setDefaultTheme() {
    UI
      .getCurrent()
      .getPage()
      .executeJs(
        "document.querySelector('html').setAttribute('theme', '" +
        ThemeUtil.getCurrentThemeVariant().getAttribute() +
        "')"
      );
  }

  private void addHeaderContent(Tabs menu) {
    DrawerToggle toggle = new DrawerToggle();
    toggle.getElement().setAttribute("aria-label", "Menu toggle");

    viewTitle = new H2();
    viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

    Select<String> select = new Select<>();
    select.setLabel("Sort by");
    select.setItems("Most recent first", "Rating: high to low", "Rating: low to high");
    select.setPlaceholder("Select");
    addToNavbar(true, toggle, viewTitle, menu);
  }

  private void addDrawerContent() {
    H1 appName = new H1("ZUI");
    appName.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);
    Header header = new Header(appName);

    Scroller scroller = new Scroller(createNavigation());

    addToDrawer(header, scroller, createFooter());
  }

  private AppNav createNavigation() {
    // AppNav is not yet an official component.
    // For documentation, visit https://github.com/vaadin/vcf-nav#readme
    AppNav nav = new AppNav();

    FloatingComponent cardFC = new FloatingComponent(new AppNavItem("Card List", CardListView.class, "la la-list"));
   // nav.addItem()
   nav.addItem(new AppNavItem("Floating Component", AboutView.class, "la la-file")
       .addItem(new AppNavItem("Floating Component", AboutView.class, "la la-file")));
   nav.addItem(new AppNavItem("Card List", CardListView.class, "la la-list"));
   nav.addItem(new AppNavItem("Image List", ImageListView.class, "la la-th-list"));
   nav.addItem(new AppNavItem("Checkout Form", CheckoutFormView.class, "la la-credit-card"));
    return nav;
  }

  private Footer createFooter() {
    Footer layout = new Footer();

    return layout;
  }

  @Override
  protected void afterNavigation() {
    super.afterNavigation();
    viewTitle.setText(getCurrentPageTitle());
  }

  private String getCurrentPageTitle() {
    PageTitle title = getContent().getClass().getAnnotation(PageTitle.class);
    return title == null ? "" : title.value();
  }
}
