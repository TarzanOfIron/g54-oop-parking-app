package se.lexicon.model;

import se.lexicon.dao.sequencer.ReservationIdSequencer;

import java.time.LocalDateTime;

public class Reservation {

    private int id;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Customer renter;
    private ParkingSpot parkingSpot;

    public Reservation(LocalDateTime startDateTime, LocalDateTime endDateTime, Customer renter, ParkingSpot parkingSpot) {
        setId();
        setStartDateTime(startDateTime);
        setEndDateTime(endDateTime);
        setRenter(renter);
        setParkingSpot(parkingSpot);
    }


    public int getId() {
        return id;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public Customer getRenter() {
        return renter;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }


    private void setId() {
        this.id = ReservationIdSequencer.nextId();
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public void setRenter(Customer renter) {
        this.renter = renter;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", startDateTime=" + startDateTime +
                ", endDateTime=" + endDateTime +
                ", renter=" + renter +
                ", parkingSpot=" + parkingSpot +
                '}';
    }
}
