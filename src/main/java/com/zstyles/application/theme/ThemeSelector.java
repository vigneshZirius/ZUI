package com.zstyles.application.theme;

import com.vaadin.flow.component.ComponentUtil;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.tabs.TabsVariant;
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;

/**
 * @author erik@vaadin.com
 * @since 20.5.2021
 */
public class ThemeSelector extends Tabs {

    public ThemeSelector() {
        setOrientation(Tabs.Orientation.HORIZONTAL);
        addThemeVariants(TabsVariant.LUMO_MINIMAL);
        setId("tabs");
        addClassName("ml-auto");
        addSelectedChangeListener(e -> {
            // Don't fire when we call setSelectedTab(tab) in the for-loop below
            if (e.isFromClient()) {
                ThemeVariant themeVariant = ComponentUtil.getData(e.getSelectedTab(), ThemeVariant.class);
                ThemeUtil.selectThemeVariant(themeVariant);
            }
        });

        ThemeVariant currentThemeVariant = ThemeUtil.getCurrentThemeVariant();
        for (ThemeVariant themeVariant : ThemeVariant.values()) {
            Tab tab = new Tab(themeVariant.getCaption());
            ComponentUtil.setData(tab, ThemeVariant.class, themeVariant);
            add(tab);

            if (currentThemeVariant == themeVariant) {
                setSelectedTab(tab);
            }
        }
    }
}
