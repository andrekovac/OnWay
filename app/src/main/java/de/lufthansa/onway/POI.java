package de.lufthansa.onway;

import android.support.annotation.DrawableRes;
import java.util.UUID;

public class POI {
    private final String name;
    private final int iconRes;

    private final UUID id1hex;
    private final UUID id2hex;

    public POI(final String name, final int iconRes, final UUID id1hex, final UUID id2hex) {
        this.name = name;
        this.iconRes = iconRes;
        this.id1hex = id1hex;
        this.id2hex = id2hex;
    }

    public String getName() {
        return name;
    }

    @DrawableRes
    public int getIconRes() {
        return iconRes;
    }

    public UUID getId1hex() {
        return id1hex;
    }

    public UUID getId2hex() {
        return id2hex;
    }
}
