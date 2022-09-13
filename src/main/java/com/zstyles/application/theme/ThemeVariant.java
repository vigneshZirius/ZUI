package com.zstyles.application.theme;

/**
 * @author erik@vaadin.com
 * @since 20.5.2021
 */
public enum ThemeVariant {
    DAY("day"), NIGHT("night");

    private final String caption;

    ThemeVariant(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }

    public String getAttribute() {
        return name().toLowerCase();
    }
}
