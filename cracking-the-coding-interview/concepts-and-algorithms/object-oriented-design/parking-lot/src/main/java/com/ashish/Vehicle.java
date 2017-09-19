package com.ashish;

public class Vehicle {
    private ParkingSlot assignedParkingSlot;

    private VehicleType vehicleType;

    public Vehicle(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void addToParking(ParkingSlot parkingSlot) {
        parkingSlot.setStatus(ParkingSlot.ParkingSlotStatus.Occupied);
        this.assignedParkingSlot = parkingSlot;
    }

    public ParkingSlot removeFromParking() {
        assignedParkingSlot.setStatus(ParkingSlot.ParkingSlotStatus.Empty);
        ParkingSlot removedFromParkingSlot = assignedParkingSlot;
        assignedParkingSlot = null;
        return removedFromParkingSlot;
    }

    public enum VehicleType {
        FourWheeler, TwoWheeler
    }
}
