package tech.blueglacier;

public class EntryGate extends Gate {

    private int carInCount;
    private int bikeInCount;
    private int bicycleInCount;

    public EntryGate(String gateName) {
        super(gateName);
    }

    public void incrementCarCount() {
        carInCount++;
    }

    public void incrementBikeCount() {
        bikeInCount++;
    }

    public void incrementBicycleCount() {
        bicycleInCount++;
    }

    public int getCarInCount() {
        return carInCount;
    }

    public int getBikeInCount() {
        return bikeInCount;
    }

    public int getBicycleInCount() {
        return bicycleInCount;
    }
}
