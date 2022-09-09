package com.zstyles.application;

import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import com.vaadin.flow.server.communication.IndexHtmlRequestListener;
import com.vaadin.flow.server.communication.IndexHtmlResponse;
import com.zstyles.application.theme.ThemeUtil;

import org.springframework.stereotype.Component;

/**
 * @author erik@vaadin.com
 * @since 20.5.2021
 */
@Component
public class ThemeBoostrapListener implements VaadinServiceInitListener, IndexHtmlRequestListener {

    @Override
    public void serviceInit(ServiceInitEvent event) {
        event.addIndexHtmlRequestListener(this);
    }

    @Override
    public void modifyIndexHtmlResponse(IndexHtmlResponse indexHtmlResponse) {
        indexHtmlResponse.getDocument().body().attr(
                ThemeUtil.THEME_ATTRIBUTE,
                ThemeUtil.getCurrentThemeVariant().getAttribute());
    }


}