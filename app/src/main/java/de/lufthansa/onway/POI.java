package de.lufthansa.onway;

import android.support.annotation.DrawableRes;

public class POI {
    private final String name;
    private final int iconRes;


    public POI(final String name,  final int iconRes) {
        this.name = name;
        this.iconRes = iconRes;
    }

    public String getName() {
        return name;
    }

    @DrawableRes
    public int getIconRes() {
        return iconRes;
    }
}
