package tech.blueglacier;

import java.util.List;
import java.util.Optional;

public class Trip {

    private Waypoint source;
    private Waypoint destination;

    private List<Waypoint> waypointList;

    public Trip(Waypoint source, Waypoint destination, List<Waypoint> waypointList){
        this.source = source;
        this.destination = destination;
        this.waypointList = waypointList;

    }

    public Waypoint getSource() {
        return source;
    }

    public void setSource(Waypoint source) {
        this.source = source;
    }

    public Waypoint getDestination() {
        return destination;
    }

    public void setDestination(Waypoint destination) {
        this.destination = destination;
    }

    public List<Waypoint> getWaypointList() {
        return waypointList;
    }

    public void setWaypointList(List<Waypoint> waypointList) {
        this.waypointList = waypointList;
    }

    public Optional<Waypoint> isWayPointMatch(Waypoint destination){
        return waypointList.stream().filter(waypoint-> {return waypoint.getWaypointName().equals(destination.getWaypointName());}).findFirst();
    }
}
