package tech.blueglacier;


public class CabUser {

    private ShareCabService shareCabService;

    public CabUser(ShareCabService shareCabService) {
        this.shareCabService = shareCabService;
    }

    public Cab bookACab(Waypoint destination) {
        Cab sharedCab = shareCabService.getCabGoingToSameDestination(destination);

        return sharedCab;

    }
}
