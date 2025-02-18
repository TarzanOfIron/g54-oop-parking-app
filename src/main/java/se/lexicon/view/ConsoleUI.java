package se.lexicon.view;

import se.lexicon.model.Customer;
import se.lexicon.model.ParkingSpot;
import se.lexicon.model.Vehicle;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    private final Scanner scanner = new Scanner(System.in);


    public void displayMenu(){
        System.out.println("1. Register Customer");
        System.out.println("2. Display Parking Spots");
        System.out.println("3. Reserve a parking spot");
        System.out.println("4. Vacate a parking spot");
        System.out.println("5. Exit");
    }


    public String getInput(String prompt){
        String input;
        while (true){
            System.out.println(prompt);
            input = scanner.next().trim();

            if (input.isEmpty()){
                System.out.println("Input cannot be empty. please try again.");
            } else {
                break;
            }
        }

        return input;
    }

    public int getIntInput(String prompt){
        int input;
        while (true){
            System.out.println(prompt);
            input = scanner.nextInt();

            if (input < 0 || input > 9)  {
                System.out.println("Input cannot be empty. please try again.");
            } else {
                break;
            }
        }

        return input;
    }



    public Customer getCustomerInfoWithVehicle(){
        scanner.nextLine();
        System.out.println("Enter name:");
        String name = scanner.nextLine();

        System.out.println("Enter phone number:");
        String phoneNumber = scanner.nextLine();

        System.out.println("Enter plate number:");
        String plateNumber = scanner.nextLine();

        System.out.println("Enter vehicle type(Car, Motorcycle, Truck, and...):");
        String vehicleType = scanner.nextLine();

        return new Customer(name, phoneNumber, new Vehicle(plateNumber, vehicleType));
    }


    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displaySuccessMessage(String message) {
        final String GREEN_COLOR = "\u001B[32m"; // ANSI escape code for green color
        final String RESET_COLOR = "\u001B[0m"; // Reset text color to default

        System.out.println(GREEN_COLOR + message + RESET_COLOR);
    }

    public void displayErrorMessage(String message) {
        final String RED_COLOR = "\u001B[31m"; // ANSI escape code for red color
        final String RESET_COLOR = "\u001B[0m"; // Reset text color to default

        System.out.println(RED_COLOR + message + RESET_COLOR);
    }


    public void displayParkingSpots(List<ParkingSpot> parkingSpots){
            System.out.print("|");
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.isAvailable()) {
                System.out.print(" ");
            } else {
                System.out.print("X");
            }
            System.out.print("|");
        }
        System.out.println();

    }

}
