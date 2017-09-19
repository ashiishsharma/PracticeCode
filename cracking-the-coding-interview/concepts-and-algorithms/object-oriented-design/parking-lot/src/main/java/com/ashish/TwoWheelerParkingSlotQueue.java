package com.ashish;

public class TwoWheelerParkingSlotQueue extends ParkingSlotQueue {
    public TwoWheelerParkingSlotQueue(int parkingSlotCount) {
        super(parkingSlotCount, ParkingSlot.ParkingSlotType.TwoWheeler);
    }
}
