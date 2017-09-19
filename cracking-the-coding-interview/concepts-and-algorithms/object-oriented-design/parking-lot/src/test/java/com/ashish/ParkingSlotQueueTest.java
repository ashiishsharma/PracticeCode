package com.ashish;

import com.ashish.exception.NonEmptyParkingSlotReturned;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParkingSlotQueueTest {

    private ParkingSlotQueue parkingSlotQueue;
    private ParkingSlot parkingSlot;

    @BeforeMethod
    public void initialize() {
        parkingSlotQueue = new TwoWheelerParkingSlotQueue(2);
    }

    @Test
    public void testParkingSlotQueue() {
        parkingSlot = parkingSlotQueue.getParkingSlot();
        Assert.assertNotNull(parkingSlot);
        Assert.assertEquals(parkingSlot.getStatus(), ParkingSlot.ParkingSlotStatus.Empty);
    }

    @Test
    public void testEmptyParkingSlotQueue() {
        parkingSlotQueue.getParkingSlot();
        parkingSlotQueue.getParkingSlot();
        parkingSlot = parkingSlotQueue.getParkingSlot();
        Assert.assertNull(parkingSlot);
    }

    @Test
    public void testReturnParkingSlot() {
        parkingSlotQueue.getParkingSlot();
        parkingSlot = parkingSlotQueue.getParkingSlot();
        parkingSlotQueue.returnParkingSlot(parkingSlot);
    }

    @Test(expectedExceptions = {NonEmptyParkingSlotReturned.class})
    public void testReturnOccupiedParkingSlot() {
        parkingSlotQueue.getParkingSlot();
        parkingSlot = parkingSlotQueue.getParkingSlot();
        parkingSlot.setStatus(ParkingSlot.ParkingSlotStatus.Occupied);
        parkingSlotQueue.returnParkingSlot(parkingSlot);
    }
}
