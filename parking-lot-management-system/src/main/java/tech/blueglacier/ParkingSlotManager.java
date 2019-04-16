package tech.blueglacier;

public class ParkingSlotManager {
    private ParkingQueue parkingQueue;

    public ParkingSlotManager(ParkingQueue parkingQueue) {
        this.parkingQueue = parkingQueue;
    }

    public void addParkingSlot(BikeParkingSlot bikeParkingSlot) {
        parkingQueue.addBikeParkingSlot(bikeParkingSlot);
    }

    public void addParkingSlot(CarParkingSlot carParkingSlot) {
        parkingQueue.addCarParkingSlot(carParkingSlot);
    }

    public void addParkingSlot(BicycleParkingSlot bicycleParkingSlot) {
        parkingQueue.addBicycleParkingSlot(bicycleParkingSlot);
    }

    public boolean isAvailable(Bike bike) {
        if (parkingQueue.getBikeParkingSlotList().size() > 0) {
            return true;
        }
        return false;
    }

    public boolean isAvailable(Car car) {
        if (parkingQueue.getCarParkingSlotList().size() > 0) {
            return true;
        }
        return false;
    }

    public boolean isAvailable(Bicycle bicycle) {
        if (parkingQueue.getBicycleParkingSlotList().size() > 0) {
            return true;
        }
        return false;
    }

    public boolean parkVehicle(Car car) {
        if (isAvailable(car)) {
            ParkingSlot parkingSlot = parkingQueue.getCarParkingSlot();
            parkingSlot.setVehicle(car);
            parkingQueue.getCarParkingSlotMap().put(car.getVehicleID(), (CarParkingSlot) parkingSlot);
            return true;
        }
        return false;
    }

    public boolean parkVehicle(Bike bike) {
        if (isAvailable(bike)) {
            ParkingSlot parkingSlot = parkingQueue.getBikeParkingSlot();
            parkingSlot.setVehicle(bike);
            parkingQueue.getBikeParkingSlotMap().put(bike.getVehicleID(), (BikeParkingSlot) parkingSlot);
            return true;
        }
        return false;
    }

    public boolean parkVehicle(Bicycle bicycle) {
        if (isAvailable(bicycle)) {
            ParkingSlot parkingSlot = parkingQueue.getBiCycleParkingSlot();
            parkingSlot.setVehicle(bicycle);
            parkingQueue.getBicycleParkingSlotMap().put(bicycle.getVehicleID(), (BicycleParkingSlot) parkingSlot);
            return true;
        }
        return false;
    }

    public void printAllAvailableSlots() {
        int carParkingSlots = parkingQueue.getCarParkingSlotList().size();
        int bikeParkingSlots = parkingQueue.getBikeParkingSlotList().size();
        int bicycleParkingSlots = parkingQueue.getBicycleParkingSlotList().size();
        int totalSlots = carParkingSlots + bikeParkingSlots + bicycleParkingSlots;

        System.out.println("Total Available:" + totalSlots);
        System.out.println("Car:" + carParkingSlots);
        System.out.println("Bike:" + bikeParkingSlots);
        System.out.println("Bicycle:" + bicycleParkingSlots);
    }

    public boolean unParkVehicle(Bike bike) {
        ParkingSlot parkingSlot = parkingQueue.getBikeParkingSlotMap().get(bike.getVehicleID());
        parkingSlot.setVehicle(null);
        parkingQueue.addBikeParkingSlot((BikeParkingSlot) parkingSlot);
        return true;
    }

}
