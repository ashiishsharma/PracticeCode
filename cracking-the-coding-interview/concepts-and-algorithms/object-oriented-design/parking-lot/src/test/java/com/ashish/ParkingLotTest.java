package com.ashish;

import com.ashish.exception.ParkingNotAvailableException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * 8.4
 * <p>
 * Design a parking lot using object-oriented principles.
 * <p>
 * <p>Solution</p>
 * <p>The parking slots are the identifiers of parking lot,
 * as soon as a parking slot is provided,
 * the vehicle is capable to guide and park itself</p>
 *
 * @author Ashish Sharma on 9/19/2017.
 * <p>
 * @since 9/19/2017.
 */
public class ParkingLotTest {

    private ParkingLot parkingLot;

    @BeforeMethod
    public void initialize() {
        parkingLot = new ParkingLot();
    }

    @Test
    public void testParkVehicle() throws ParkingNotAvailableException {
        Vehicle car = new Vehicle(Vehicle.VehicleType.FourWheeler);
        parkingLot.parkVehicle(car);
        Assert.assertEquals(parkingLot.getParkedVehicleList().size(),1);
    }

    @Test(expectedExceptions = {ParkingNotAvailableException.class})
    public void testParkVehicleWhenParkingFull() throws ParkingNotAvailableException {
        Vehicle car = new Vehicle(Vehicle.VehicleType.FourWheeler);
        Vehicle car2 = new Vehicle(Vehicle.VehicleType.FourWheeler);
        Vehicle car3 = new Vehicle(Vehicle.VehicleType.FourWheeler);
        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(car2);
        parkingLot.parkVehicle(car3);
    }

    @Test
    public void testUnparkVehicle() throws ParkingNotAvailableException {
        Vehicle car = new Vehicle(Vehicle.VehicleType.FourWheeler);
        Vehicle car2 = new Vehicle(Vehicle.VehicleType.FourWheeler);
        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(car2);
        Assert.assertEquals(parkingLot.getParkedVehicleList().size(),2);
        parkingLot.unParkVehicle(car);
        Assert.assertEquals(parkingLot.getParkedVehicleList().size(),1);
    }
}
