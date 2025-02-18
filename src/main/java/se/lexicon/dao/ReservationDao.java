package se.lexicon.dao;

import se.lexicon.model.Reservation;

public interface ReservationDao {

    void makeReservation(Reservation reservation);

    void cancelReservation(int id);






}
