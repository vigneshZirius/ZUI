package com.zstyles.application.views;


import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.zstyles.application.components.appnav.AppNav;
import com.zstyles.application.components.appnav.AppNavItem;
import com.zstyles.application.views.about.AboutView;
import com.zstyles.application.views.cardlist.CardListView;
import com.zstyles.application.views.checkoutform.CheckoutFormView;
import com.zstyles.application.views.dashboard.DashboardView;
import com.zstyles.application.views.imagelist.ImageListView;
import com.zstyles.application.views.list.ListView;
import com.zstyles.application.views.masterdetail.MasterDetailView;

/**
 * The main view is a top-level placeholder for other views.
 */
public class MainLayout extends AppLayout {

    private H2 viewTitle;

    public MainLayout() {
        setPrimarySection(Section.DRAWER);
        addDrawerContent();
        addHeaderContent();
    }

    private void addHeaderContent() {
        DrawerToggle toggle = new DrawerToggle();
        toggle.getElement().setAttribute("aria-label", "Menu toggle");

        viewTitle = new H2();
        viewTitle.addClassNames(LumoUtility.FontSize.LARGE, LumoUtility.Margin.NONE);

        addToNavbar(true, toggle, viewTitle);
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

        nav.addItem(new AppNavItem("Dashboard", DashboardView.class, "la la-chart-area"));
        nav.addItem(new AppNavItem("List", ListView.class, "la la-th"));
        nav.addItem(new AppNavItem("Card List", CardListView.class, "la la-list"));
        nav.addItem(new AppNavItem("Image List", ImageListView.class, "la la-th-list"));
        nav.addItem(new AppNavItem("Checkout Form", CheckoutFormView.class, "la la-credit-card"));
        nav.addItem(new AppNavItem("Master-Detail", MasterDetailView.class, "la la-columns"));
        nav.addItem(new AppNavItem("About", AboutView.class, "la la-file"));

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
