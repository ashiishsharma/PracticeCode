package com.ashish;

public class Computer {
    private String ramSize;
    private String hddSize;

    private boolean isGraphicsCardEnabled;
    private boolean isWiFiEnabled;

    private Computer(ComputerBuilder computerBuilder) {
        this.ramSize = computerBuilder.ramSize;
        this.hddSize = computerBuilder.hddSize;
        this.isGraphicsCardEnabled = computerBuilder.isGraphicsCardEnabled;
        this.isWiFiEnabled = computerBuilder.isWiFiEnabled;
    }

    public String getRamSize() {
        return ramSize;
    }

    public String getHddSize() {
        return hddSize;
    }

    public boolean isGraphicsCardEnabled() {
        return isGraphicsCardEnabled;
    }

    public boolean isWiFiEnabled() {
        return isWiFiEnabled;
    }

    public static class ComputerBuilder {

        private String ramSize;
        private String hddSize;

        private boolean isGraphicsCardEnabled;
        private boolean isWiFiEnabled;

        public ComputerBuilder(String ramSize, String hddSize) {
            this.hddSize = hddSize;
            this.ramSize = ramSize;
        }

        public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }

        public ComputerBuilder setWiFiEnabled(boolean isWiFiEnabled) {
            this.isWiFiEnabled = isWiFiEnabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
