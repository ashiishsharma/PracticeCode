package com.ashish;

import com.ashish.exception.ParkingNotAvailableException;

import java.util.ArrayList;
import java.util.List;

/**
 * 8.4
 * <p>
 * Design a parking lot using object-oriented principles.
 * <p>
 * <p>Solution</p>
 * <p>The parking slots are the identifiers of parking lot,
 * as soon as a parking slot is provided,
 * the vehicle is capable to guide and park itself there by itself </p>
 *
 * @author Ashish Sharma on 9/19/2017.
 * <p>
 * @since 9/19/2017.
 */
public class ParkingLot {
    private List<Vehicle> parkedVehicleList;
    private ParkingSlotQueue fourWheelerParkingSlotQueue;
    private ParkingSlotQueue twoWheelerParkingSlotQueue;

    public ParkingLot() {
        parkedVehicleList = new ArrayList<Vehicle>();
        fourWheelerParkingSlotQueue = new FourWheelerParkingSlotQueue(2);
        twoWheelerParkingSlotQueue = new TwoWheelerParkingSlotQueue(2);
    }

    public void parkVehicle(Vehicle vehicle) throws ParkingNotAvailableException {
        ParkingSlot parkingSlot = null;
        if (vehicle.getVehicleType() == Vehicle.VehicleType.FourWheeler) {
            parkingSlot = fourWheelerParkingSlotQueue.getParkingSlot();
        } else if (vehicle.getVehicleType() == Vehicle.VehicleType.TwoWheeler) {
            parkingSlot = twoWheelerParkingSlotQueue.getParkingSlot();
        }
        if (parkingSlot != null) {
            vehicle.addToParking(parkingSlot);
            parkedVehicleList.add(vehicle);
        } else {
            System.out.println("No parking slot available, try later ...");
            throw new ParkingNotAvailableException("No parking slot available");
        }
    }

    public void unParkVehicle(Vehicle vehicle) {
        ParkingSlot parkingSlot = vehicle.removeFromParking();
        if (vehicle.getVehicleType() == Vehicle.VehicleType.FourWheeler) {
            fourWheelerParkingSlotQueue.returnParkingSlot(parkingSlot);
        } else if (vehicle.getVehicleType() == Vehicle.VehicleType.TwoWheeler) {
            twoWheelerParkingSlotQueue.returnParkingSlot(parkingSlot);
        }
        parkedVehicleList.remove(vehicle);
    }

    public List<Vehicle> getParkedVehicleList() {
        return parkedVehicleList;
    }
}
