package com.ashish;

public class ParkingSlot {
    private int parkingSlotNumber;
    private ParkingSlotType type;
    private ParkingSlotStatus status;

    public ParkingSlot(int parkingSlotNumber, ParkingSlotType parkingSlotType){
        this.parkingSlotNumber = parkingSlotNumber;
        this.type = parkingSlotType;
        this.status = ParkingSlotStatus.Empty;
    }

    public ParkingSlotStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingSlotStatus status) {
        this.status = status;
    }

    public enum ParkingSlotStatus {
        Occupied, Empty
    }

    public enum ParkingSlotType {
        FourWheeler, TwoWheeler
    }
}
