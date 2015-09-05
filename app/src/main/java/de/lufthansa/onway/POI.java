package de.lufthansa.onway;

import android.support.annotation.DrawableRes;

public class POI {
    private final String name;
    private final int iconRes;

    private final String mac;

    public POI(final String name, final int iconRes, final String mac) {
        this.name = name;
        this.iconRes = iconRes;
        this.mac = mac;
    }

    public String getName() {
        return name;
    }

    @DrawableRes
    public int getIconRes() {
        return iconRes;
    }

    public String getMac() {
        return mac;
    }
}
