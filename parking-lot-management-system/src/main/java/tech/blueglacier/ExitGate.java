package tech.blueglacier;

public class ExitGate extends Gate {

    private int carOutCount;
    private int bikeOutCount;
    private int bicycleOutCount;

    public ExitGate(String gateName) {
        super(gateName);
    }

    public void incrementCarCount() {
        carOutCount++;
    }

    public void incrementBikeCount() {
        bikeOutCount++;
    }

    public void incrementBicycleCount() {
        bicycleOutCount++;
    }

    public int getCarOutCount() {
        return carOutCount;
    }

    public int getBikeOutCount() {
        return bikeOutCount;
    }

    public int getBicycleOutCount() {
        return bicycleOutCount;
    }
}
