package tech.blueglacier;

public abstract class Gate {
    private String gateName;

    public Gate(String gateName) {
        this.gateName = gateName;
    }

    public String getGateName() {
        return gateName;
    }

    public abstract void incrementCarCount();

    public abstract void incrementBikeCount();

    public abstract void incrementBicycleCount();

}
