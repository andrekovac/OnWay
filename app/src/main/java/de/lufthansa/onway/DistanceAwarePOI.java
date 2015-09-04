package de.lufthansa.onway;

public class DistanceAwarePOI extends POI {
    private final int distanceInMeters;


    public DistanceAwarePOI(final String name, final int distanceInMeters, final int iconRes) {
        super(name, iconRes);
        this.distanceInMeters = distanceInMeters;
    }

    public int getDistanceInMeters() {
        return distanceInMeters;
    }

}
