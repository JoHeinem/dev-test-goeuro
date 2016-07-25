package de.johannes.heinemann.devtest;

/**
 * Represents one JSON object from the JSON Array.
 *
 * @author johannes heinemann
 */
public class JSONObject {

    public JSONObject(String type, int _id, String name, GeoPosition geo_position) {
        this.type = type;
        this._id = _id;
        this.name = name;
        this.geo_position = geo_position;
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
