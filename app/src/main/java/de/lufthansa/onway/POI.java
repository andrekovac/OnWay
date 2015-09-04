package de.lufthansa.onway;

import android.support.annotation.DrawableRes;

public class POI {
    private final String name;
    // category
    private final int distanceInMeters;
    private final int iconRes;


    public POI(final String name, final int distanceInMeters, final int iconRes) {
        this.name = name;
        this.distanceInMeters = distanceInMeters;
        this.iconRes = iconRes;
    }

    public String getName() {
        return name;
    }

    public int getDistanceInMeters() {
        return distanceInMeters;
    }

    @DrawableRes
    public int getIconRes() {
        return iconRes;
    }
}
