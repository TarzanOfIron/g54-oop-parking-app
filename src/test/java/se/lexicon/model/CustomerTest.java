package se.lexicon.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    Customer testObject;

    @BeforeEach
    public void setup() {
        testObject = new Customer(
                1,
                "Mehrdad Javan",
                "0123456789",
                new Vehicle(
                        "ABC 123",
                        "Car")
        );
    }

    @Test
    void testCustomerCreation() {
        assertEquals(1, testObject.getId());
        assertEquals("Mehrdad Javan", testObject.getName());
        assertEquals("0123456789", testObject.getPhoneNumber());

    }

    @Test
    void testSetValidPhoneNumber() {
        testObject.setPhoneNumber("9876543210");
        assertEquals("9876543210", testObject.getPhoneNumber());
    }


    @Test
    void testSetInvalidPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> testObject.setPhoneNumber("123456"));
    }

    @Test
    void testSetNullPhoneNumber() {
        assertThrows(IllegalArgumentException.class, () -> testObject.setPhoneNumber(null));
    }


    @Test
    void testSetName() {
        testObject.setName("Boti");
        assertEquals("Boti", testObject.getName());
    }

    @Test
    void testSetInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> testObject.setName(" "));
    }
}
