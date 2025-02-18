package se.lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VehicleTest {
    // todo: implement later

    Vehicle testObject;

    @BeforeEach
    public void setup() {
        testObject = new Vehicle("123-asd", "Car");
    }


    @Test
    void setTypeAirplane () {
        testObject.setType("Airplane");
        assertEquals("Airplane", testObject.getType());
    }

    @Test
    void setInvalidType () {
        assertThrows(NullPointerException.class, () -> testObject.setType(null));
    }

    @Test
    void setPlateNumber() {
        testObject.setPlateNumber("111 aaa");
        assertEquals("111 aaa", testObject.getPlateNumber());
    }

    @Test
    void setInvalidPlateNumber () {
        assertThrows(NullPointerException.class, () -> testObject.setPlateNumber(null));
    }
}
