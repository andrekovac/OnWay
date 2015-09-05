package de.lufthansa.onway;

public class DistanceAwarePOI extends POI {
    private final double distanceInMeters;


    public DistanceAwarePOI(final String name, final double distanceInMeters, final int iconRes, String mac) {
        super(name, iconRes, mac);
        this.distanceInMeters = distanceInMeters;
    }

    public double getDistanceInMeters() {
        return distanceInMeters;
    }

}
