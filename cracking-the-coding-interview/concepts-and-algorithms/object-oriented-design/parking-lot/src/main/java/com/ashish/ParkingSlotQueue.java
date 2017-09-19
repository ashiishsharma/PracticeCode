package com.ashish;

import com.ashish.exception.NonEmptyParkingSlotReturned;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public abstract class ParkingSlotQueue {
    private Queue<ParkingSlot> emptyParkingQueue;

    public ParkingSlotQueue(int parkingSlotCount, ParkingSlot.ParkingSlotType parkingSlotType) {
        emptyParkingQueue = new LinkedList();
        initializeParkingSlots(parkingSlotCount, parkingSlotType);
    }

    private void initializeParkingSlots(int parkingSlotCount, ParkingSlot.ParkingSlotType parkingSlotType) {
        for (int i = 0; i < parkingSlotCount; i++) {
            emptyParkingQueue.add(new ParkingSlot(i, parkingSlotType));
        }
    }

    public ParkingSlot getParkingSlot(){
        ParkingSlot parkingSlot;
        try {
            parkingSlot = emptyParkingQueue.remove();
        }catch (NoSuchElementException e){
            parkingSlot = null;
            System.out.println("No parking slot available");
        }
        return parkingSlot;
    }

    public void returnParkingSlot(ParkingSlot parkingSlot){
        if(parkingSlot.getStatus() == ParkingSlot.ParkingSlotStatus.Empty){
            emptyParkingQueue.add(parkingSlot);
        }else{
            throw new NonEmptyParkingSlotReturned("Parking slot should be empty");
        }
    }
}
