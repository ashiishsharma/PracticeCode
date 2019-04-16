package tech.blueglacier;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ParkingLotTest {

    private ParkingLot parkingLot;
    private ParkingSlotManager parkingSlotManager;
    private ParkingQueue parkingQueue;
    private GateManager gateManager;
    private BikeParkingSlot bikeParkingSlot;
    private CarParkingSlot carParkingSlot1;
    private BicycleParkingSlot bicycleParkingSlot;
    private CarParkingSlot carParkingSlot2;
    private EntryGate entryGate1;
    private EntryGate entryGate2;
    private Car car1;
    private Bike bike1;
    private Bike bike2;
    private ExitGate exitGate1;

    @BeforeMethod
    public void init() {
        parkingQueue = new ParkingQueue(ParkingPolicy.SEQUENTIAL);
        parkingSlotManager = new ParkingSlotManager(parkingQueue);

        bikeParkingSlot = new BikeParkingSlot(1);
        carParkingSlot1 = new CarParkingSlot(1);
        carParkingSlot2 = new CarParkingSlot(2);
        bicycleParkingSlot = new BicycleParkingSlot(1);


        parkingSlotManager.addParkingSlot(bikeParkingSlot);
        parkingSlotManager.addParkingSlot(carParkingSlot1);
        parkingSlotManager.addParkingSlot(carParkingSlot2);
        parkingSlotManager.addParkingSlot(bicycleParkingSlot);


        gateManager = new GateManager();
        entryGate1 = new EntryGate("Gate1");
        gateManager.addEntryGate(entryGate1);

        entryGate2 = new EntryGate("Gate2");
        gateManager.addEntryGate(entryGate2);
        gateManager.addEntryGate(new EntryGate("Gate3"));
        gateManager.addEntryGate(new EntryGate("Gate4"));

        exitGate1 = new ExitGate("Gate1");
        gateManager.addExitGate(exitGate1);
        gateManager.addExitGate(new ExitGate("Gate2"));
    }

    @Test(priority = 1, description = "1")
    public void testParkingLot() {
        parkingLot = new ParkingLot("PVR Kormangla", parkingSlotManager, gateManager);
        Assert.assertNotNull(parkingLot, "Parking Lot Created");
    }

    @Test(priority = 2, description = "2")
    public void testIsAvailable_BIKE1_GATE1() {
        bike1 = new Bike("BIKE1");
        Assert.assertTrue(parkingLot.isAvailable(bike1, entryGate1));
    }

    @Test(priority = 3, description = "3")
    public void testIsAvailable_CAR1_GATE1() {
        car1 = new Car("CAR1");
        Assert.assertTrue(parkingLot.isAvailable(car1, entryGate1));
    }

    @Test(priority = 4, description = "4")
    public void testIsAvailable_BIKE2_GATE2() {
        bike2 = new Bike("BIKE2");
        Assert.assertTrue(parkingLot.isAvailable(bike2, entryGate2));
    }

    @Test(priority = 5, description = "5")
    public void testParkVehicle_CAR1_GATE1() {
        Assert.assertTrue(parkingLot.parkVehicle(car1, entryGate1));
    }

    @Test(priority = 6, description = "6")
    public void testParkVehicle_BIKE1_GATE2() {
        Assert.assertTrue(parkingLot.parkVehicle(bike1, entryGate2));
    }

    @Test(priority = 7, description = "7")
    public void testParkVehicle_BIKE2_GATE2() {
        Assert.assertFalse(parkingLot.parkVehicle(bike2, entryGate2));
    }

    @Test(priority = 8, description = "8")
    public void testIsAvailable_BIKE2_GATE2_Again() {
        Assert.assertFalse(parkingLot.isAvailable(bike2, entryGate2));
    }

    @Test(priority = 9, description = "9")
    public void testPrintAllAvailableSlots() {
        parkingLot.printAllAvailableSlots();
    }

    @Test(priority = 10, description = "10")
    public void testPrintTotalIn() {
        parkingLot.printTotalIn(entryGate1);
    }

    @Test(priority = 11, description = "11")
    public void testPrintTotalOut() {
        parkingLot.printTotalOut(exitGate1);
    }

    @Test(priority = 12, description = "12")
    public void testUnparkVehicle() {
        parkingLot.unParkVehicle(bike1, exitGate1);
    }

}
