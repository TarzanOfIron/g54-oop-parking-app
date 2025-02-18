package se.lexicon.dao.sequencer;

public class ReservationIdSequencer {
    private static int number;

    private ReservationIdSequencer() {

    }

    public static int nextId() {
        return ++number;
    }

}
