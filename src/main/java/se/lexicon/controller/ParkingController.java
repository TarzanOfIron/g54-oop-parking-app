package se.lexicon.controller;

import se.lexicon.dao.CustomerDao;
import se.lexicon.dao.CustomerDaoImpl;
import se.lexicon.model.Customer;
import se.lexicon.model.ParkingSpot;
import se.lexicon.model.Vehicle;
import se.lexicon.view.ConsoleUI;

import java.util.ArrayList;
import java.util.Objects;

public class ParkingController {

    ConsoleUI consoleUI;
    CustomerDao customerDao;
    ArrayList<ParkingSpot> parkingSpots;


    public ParkingController() {
        consoleUI = new ConsoleUI();
        customerDao = new CustomerDaoImpl();
        parkingSpots = lexiconParkingSpots();
    }

    public void run() {
        boolean running = true;
        while (running) {
            consoleUI.displayMenu();
            String choice = consoleUI.getInput("Choose an option: "); // get use choice

            switch (choice) {
                case "1":
                    registerCustomer();
                    break;
                case "2":
                    consoleUI.displayParkingSpots(parkingSpots);
                    break;
                case "3":
                    reserveParkingSpot();
                    break;
                case "4":
                    vacateParkingSpot();
                    break;
                case "5": {
                    consoleUI.displayMessage("Exiting the app. Goodbye!");
                    running = false;
                    break;
                }
                default:
                    consoleUI.displayMessage("Invalid Option. Please try again.");
            }


        }
    }

    private void registerCustomer() {

        Customer customerData = consoleUI.getCustomerInfoWithVehicle();
        Customer createdCustomer = customerDao.create(customerData);
        consoleUI.displaySuccessMessage("Customer registered successfully with Id: " + createdCustomer.getId());

    }


    private void displayParkingSpots() {
        consoleUI.displayParkingSpots(lexiconParkingSpots());
    }


    private void reserveParkingSpot() {
        int parkingSpotId = consoleUI.getIntInput("Enter parking spot id: ");
        Integer customerId = consoleUI.getIntInput("Enter your id: ");
        parkingSpots.get(parkingSpotId).setRenter(customerDao.findById(customerId));

    }


    private void vacateParkingSpot() {
        int parkingSpotId = consoleUI.getIntInput("Enter parking spot id: ");
        parkingSpots.get(parkingSpotId).setRenter(null);
    }


    private ArrayList<ParkingSpot> lexiconParkingSpots() {
        ArrayList<ParkingSpot> arrayListToReturn = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arrayListToReturn.add(new ParkingSpot());
        }
        return  arrayListToReturn;
    }

}
