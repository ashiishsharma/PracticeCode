package tech.blueglacier;

public class Waypoint {

    public String getWaypointName() {
        return waypointName;
    }

    public void setWaypointName(String waypointName) {
        this.waypointName = waypointName;
    }

    private String waypointName;

    public Waypoint(String waypointName) {
        this.waypointName = waypointName;
    }
}
