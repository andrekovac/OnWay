package de.lufthansa.onway;

import java.util.UUID;

public class DistanceAwarePOI extends POI {
    private final int distanceInMeters;


    public DistanceAwarePOI(final String name, final int distanceInMeters, final int iconRes) {
        super(name, iconRes, UUID.randomUUID(),UUID.randomUUID());
        this.distanceInMeters = distanceInMeters;
    }

    public int getDistanceInMeters() {
        return distanceInMeters;
    }

}
