package tech.blueglacier;

public class Cab {
    private String cabId;
    private Trip trip;

    public String getCabId() {
        return cabId;
    }

    public void setCabId(String cabId) {
        this.cabId = cabId;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public Cab(String cabId, Trip trip){
        this.cabId = cabId;
        this.trip = trip;
    }

}
