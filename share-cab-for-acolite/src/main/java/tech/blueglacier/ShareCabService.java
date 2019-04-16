package tech.blueglacier;


import java.util.List;

public class ShareCabService {
    public List<Cab> getAvailableCabList() {
        return availableCabList;
    }

    public void setAvailableCabList(List<Cab> availableCabList) {
        this.availableCabList = availableCabList;
    }

    private List<Cab> availableCabList;

    public ShareCabService(List<Cab> availableCabList) {
        this.availableCabList = availableCabList;
    }

    public Cab getCabGoingToSameDestination(Waypoint destination) {
        Cab cab = getCab(destination);
        return cab;
    }

    private Cab getCab(Waypoint destination) {
        for (Cab cab : availableCabList) {
            if (cab.getTrip().getDestination().getWaypointName().equals(destination.getWaypointName())
                    || (cab.getTrip().isWayPointMatch(destination) != null)) {
                return cab;
            }
        }

        return null;
    }

}
