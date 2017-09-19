package com.ashish;

public class FourWheelerParkingSlotQueue extends ParkingSlotQueue {
    public FourWheelerParkingSlotQueue(int parkingSlotCount) {
        super(parkingSlotCount, ParkingSlot.ParkingSlotType.FourWheeler);
    }
}
