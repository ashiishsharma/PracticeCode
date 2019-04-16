package tech.blueglacier;

public abstract class Vehicle {
    public String getVehicleID() {
        return vehicleID;
    }

    private String vehicleID;

    public Vehicle(String vehicleID) {
        this.vehicleID = vehicleID;
    }
}
