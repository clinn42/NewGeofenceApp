package sfitproject.mcc.newgeofenceapp;

public class HistClass {

    private String time;
    private String radius;
    private String lat;
    private String lon;

    public HistClass(String time, String radius, String lat, String lon) {
        this.time = time;
        this.radius = radius;
        this.lat = lat;
        this.lon = lon;
    }

    public String getTime() {
        return time;
    }

    public String getRadius() {
        return radius;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }
}
