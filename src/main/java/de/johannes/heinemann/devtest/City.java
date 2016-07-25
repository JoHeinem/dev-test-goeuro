package de.johannes.heinemann.devtest;

/**
 * Created by johannes on 25/07/16.
 */
public class City {

    public City(String type, int _id, String name) {
        this.type = type;
        this._id = _id;
        this.name = name;
    }


    private int _id;
    private String type;
    private String name;
    private GeoPosition geo_position;

    public String get_idAsString() {
        return Integer.toString(_id);
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public GeoPosition getGeo_position() {
        return geo_position;
    }
}
