package tech.blueglacier;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class ShareCabTest {

    private CabUser cabUser;
    private ShareCabService shareCabService;

    @BeforeMethod
    public void init() {

    }

    @Test
    public void testShareCab() {
        Waypoint userDestination = new Waypoint("B");
        List<Cab> availableCabList = new ArrayList<>();
        Waypoint source = new Waypoint("A");
        Waypoint destination = new Waypoint("E");

        List<Waypoint> waypointList = new ArrayList<>();
        waypointList.add(new Waypoint("B"));
        waypointList.add(new Waypoint("C"));
        waypointList.add(new Waypoint("D"));

        Trip trip1 = new Trip(source, destination, waypointList);

        Cab cabOnATrip1 = new Cab("cabOnTrip1", trip1);

        availableCabList.add(cabOnATrip1);

        shareCabService = new ShareCabService(availableCabList);
        cabUser = new CabUser(shareCabService);
        Assert.assertNotNull(cabUser.bookACab(userDestination));

    }
}
