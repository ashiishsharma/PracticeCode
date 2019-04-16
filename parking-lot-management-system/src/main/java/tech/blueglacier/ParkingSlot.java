package tech.blueglacier;

public abstract class ParkingSlot {
    private int parkingSlotID;

    private Vehicle vehicle;

    public ParkingSlot(int parkingSlotID) {
        this.parkingSlotID = parkingSlotID;

    }

    public int getParkingSlotID() {
        return parkingSlotID;
    }

    public void setParkingSlotID(int parkingSlotID) {
        this.parkingSlotID = parkingSlotID;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
