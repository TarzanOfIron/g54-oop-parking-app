package se.lexicon.dao;

import se.lexicon.model.Reservation;

import java.util.HashSet;
import java.util.Iterator;

public class ReservationDaoImpl implements ReservationDao {

    private HashSet<Reservation> reservations = new HashSet<>();


    @Override
    public void makeReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    @Override
    public void cancelReservation(int id) {
        Iterator<Reservation> reservationIterator = reservations.iterator();
        Reservation curReservation = null;
        while (reservationIterator.hasNext()) {
            curReservation = reservationIterator.next();
            if (curReservation.getId() == id) {
                reservationIterator.remove();
                return;
            }
        }
    }


}
