package se.lexicon.model;

public class ParkingSpot {

    private static int sequencer;
    private int parkingSpotId;
    private Customer renter;

    // Constructor

    public ParkingSpot() {
        setParkingSpotId();
    }

    //Getters

    public int getParkingSpotId() {
        return parkingSpotId;
    }

    public Customer getRenter() {
        return renter;
    }


    //Setters
    public void setRenter(Customer renter) {
        this.renter = renter;
    }

    private void setParkingSpotId() {
        this.parkingSpotId = ++sequencer;
    }

    public boolean isAvailable() {
        return renter == null;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "parkingSpotId=" + parkingSpotId +
                ", renter=" + renter +
                '}';
    }
}
