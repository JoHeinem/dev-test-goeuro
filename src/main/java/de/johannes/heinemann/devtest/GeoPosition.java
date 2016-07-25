package de.johannes.heinemann.devtest;

/**
 * Represents a geo position.
 *
 * @author johannes heinemann
 */
public class GeoPosition {

    private double latitude;
    private double longitude;

    public GeoPosition(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getLatitudeAsString() {
        return Double.toString(latitude);
    }

    public String getLongitudeAsString() {
        return Double.toString(longitude);
    }
}
