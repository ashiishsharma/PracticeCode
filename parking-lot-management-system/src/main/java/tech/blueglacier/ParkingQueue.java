package tech.blueglacier;

import java.util.*;


public class ParkingQueue {
    private ParkingPolicy parkingPolicy;
    private List<BikeParkingSlot> bikeParkingSlotList;
    private List<CarParkingSlot> carParkingSlotList;
    private List<BicycleParkingSlot> bicycleParkingSlotList;

    private Map<String, BikeParkingSlot> bikeParkingSlotMap;
    private Map<String, CarParkingSlot> carParkingSlotMap;
    private Map<String, BicycleParkingSlot> bicycleParkingSlotMap;

    public Map<String, BikeParkingSlot> getBikeParkingSlotMap() {
        return bikeParkingSlotMap;
    }

    public Map<String, CarParkingSlot> getCarParkingSlotMap() {
        return carParkingSlotMap;
    }

    public Map<String, BicycleParkingSlot> getBicycleParkingSlotMap() {
        return bicycleParkingSlotMap;
    }

    public ParkingQueue(ParkingPolicy parkingPolicy) {
        bikeParkingSlotList = Collections.synchronizedList(new ArrayList<BikeParkingSlot>());
        carParkingSlotList = Collections.synchronizedList(new ArrayList<CarParkingSlot>());
        bicycleParkingSlotList = Collections.synchronizedList(new ArrayList<BicycleParkingSlot>());
        this.parkingPolicy = parkingPolicy;

        bikeParkingSlotMap = new Hashtable();
        carParkingSlotMap = new Hashtable();
        bikeParkingSlotMap = new Hashtable();
    }


    public void addBikeParkingSlot(BikeParkingSlot bikeParkingSlot) {
        bikeParkingSlotList.add(bikeParkingSlot);
    }

    public void addCarParkingSlot(CarParkingSlot carParkingSlot) {
        carParkingSlotList.add(carParkingSlot);
    }

    public void addBicycleParkingSlot(BicycleParkingSlot bicycleParkingSlot) {
        bicycleParkingSlotList.add(bicycleParkingSlot);
    }

    public BikeParkingSlot getBikeParkingSlot() {
        BikeParkingSlot bikeParkingSlot = null;
        if (parkingPolicy == ParkingPolicy.RANDOM) {
            bikeParkingSlot = (BikeParkingSlot) takeRandom(bikeParkingSlotList);
        } else if (parkingPolicy == ParkingPolicy.SEQUENTIAL) {
            bikeParkingSlot = (BikeParkingSlot) getSequential(bikeParkingSlotList);
        } else {
            bikeParkingSlot = (BikeParkingSlot) getSequential(bikeParkingSlotList);
        }
        return bikeParkingSlot;
    }

    public CarParkingSlot getCarParkingSlot() {
        CarParkingSlot carParkingSlot = null;
        if (parkingPolicy == ParkingPolicy.RANDOM) {
            carParkingSlot = (CarParkingSlot) takeRandom(carParkingSlotList);
        } else if (parkingPolicy == ParkingPolicy.SEQUENTIAL) {
            carParkingSlot = (CarParkingSlot) getSequential(carParkingSlotList);
        } else {
            carParkingSlot = (CarParkingSlot) getSequential(carParkingSlotList);
        }
        return carParkingSlot;
    }

    public BicycleParkingSlot getBiCycleParkingSlot() {
        BicycleParkingSlot bicycleParkingSlot = null;
        if (parkingPolicy == ParkingPolicy.RANDOM) {
            bicycleParkingSlot = (BicycleParkingSlot) takeRandom(bicycleParkingSlotList);
        } else if (parkingPolicy == ParkingPolicy.SEQUENTIAL) {
            bicycleParkingSlot = (BicycleParkingSlot) getSequential(bicycleParkingSlotList);
        } else {
            bicycleParkingSlot = (BicycleParkingSlot) getSequential(bicycleParkingSlotList);
        }
        return bicycleParkingSlot;
    }

    public List<BikeParkingSlot> getBikeParkingSlotList() {
        return bikeParkingSlotList;
    }

    public void setBikeParkingSlotList(List<BikeParkingSlot> bikeParkingSlotList) {
        this.bikeParkingSlotList = bikeParkingSlotList;
    }

    public List<CarParkingSlot> getCarParkingSlotList() {
        return carParkingSlotList;
    }

    public void setCarParkingSlotList(List<CarParkingSlot> carParkingSlotList) {
        this.carParkingSlotList = carParkingSlotList;
    }

    public List<BicycleParkingSlot> getBicycleParkingSlotList() {
        return bicycleParkingSlotList;
    }

    public void setBicycleParkingSlotList(List<BicycleParkingSlot> bicycleParkingSlotList) {
        this.bicycleParkingSlotList = bicycleParkingSlotList;
    }

    public synchronized ParkingSlot getSequential(List parkingSlotList) {
        if (!parkingSlotList.isEmpty()) {
            return (ParkingSlot) parkingSlotList.remove(0);
        } else {
            return null;
        }
    }


    public synchronized ParkingSlot takeRandom(List parkingSlotList) {
        if (!parkingSlotList.isEmpty()) {
            Random random = new Random();
            int randomInt = random.ints(0, parkingSlotList.size()).findFirst().getAsInt();
            return (ParkingSlot) parkingSlotList.remove(randomInt);
        } else {
            return null;
        }
    }
}
