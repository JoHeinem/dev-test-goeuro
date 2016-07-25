package de.johannes.heinemann.devtest;

/**
 * Created by johannes on 25/07/16.
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
