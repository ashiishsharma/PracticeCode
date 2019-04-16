package tech.blueglacier;

public class ParkingLot {
    private GateManager gateManager;
    private ParkingSlotManager parkingSlotManager;
    private String parkingLotName;

    public ParkingLot(String parkingLotName, ParkingSlotManager parkingSlotManager, GateManager gateManager) {
        this.parkingLotName = parkingLotName;
        this.parkingSlotManager = parkingSlotManager;
        this.gateManager = gateManager;
    }

    public boolean isAvailable(Bike bike, EntryGate entryGate) {
        return parkingSlotManager.isAvailable(bike);
    }

    public boolean isAvailable(Car car, EntryGate entryGate) {
        return parkingSlotManager.isAvailable(car);
    }

    public boolean parkVehicle(Car car, EntryGate entryGate) {
        if (parkingSlotManager.parkVehicle(car)) {
            gateManager.getEntryGateMap().get(entryGate.getGateName()).incrementCarCount();
            return true;
        }
        return false;
    }

    public boolean parkVehicle(Bike bike, EntryGate entryGate) {
        if (parkingSlotManager.parkVehicle(bike)) {
            gateManager.getEntryGateMap().get(entryGate.getGateName()).incrementBikeCount();
            return true;
        }
        return false;
    }

    public boolean parkVehicle(Bicycle bicycle, EntryGate entryGate) {
        if (parkingSlotManager.parkVehicle(bicycle)) {
            gateManager.getEntryGateMap().get(entryGate.getGateName()).incrementBicycleCount();
            return true;
        }
        return false;
    }

    public void printAllAvailableSlots() {
        parkingSlotManager.printAllAvailableSlots();
    }

    public void printTotalIn(EntryGate entryGate) {
        int carInCount = gateManager.getEntryGateMap().get(entryGate.getGateName()).getCarInCount();
        int bikeInCount = gateManager.getEntryGateMap().get(entryGate.getGateName()).getBikeInCount();
        int bicycleInCount = gateManager.getEntryGateMap().get(entryGate.getGateName()).getBicycleInCount();

        System.out.println("Car :" + carInCount);
        System.out.println("Bike :" + bikeInCount);
        System.out.println("Bicycle :" + bicycleInCount);
    }

    public void printTotalOut(ExitGate exitGate) {
        int carInCount = gateManager.getExitGateMap().get(exitGate.getGateName()).getCarOutCount();
        int bikeInCount = gateManager.getExitGateMap().get(exitGate.getGateName()).getBikeOutCount();
        int bicycleInCount = gateManager.getExitGateMap().get(exitGate.getGateName()).getBicycleOutCount();

        System.out.println("Car :" + carInCount);
        System.out.println("Bike :" + bikeInCount);
        System.out.println("Bicycle :" + bicycleInCount);
    }

    public void unParkVehicle(Bike bike, ExitGate exitGate) {
        if (parkingSlotManager.unParkVehicle(bike)) {
            gateManager.getExitGateMap().get(exitGate.getGateName()).incrementBikeCount();
        }
    }
}
