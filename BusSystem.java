import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BusSystem {
    private static List<BusManager> buses = new ArrayList<>();
    private static List<Passenger> passengers = new ArrayList<>();
    private static List<Booking> bookings = new ArrayList<>();
    private static List<Payment> payments = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        
        System.out.println("===============================================");
        System.out.println("      Welcome to the Bus Management System     ");
        System.out.println("===============================================");

        while (!exit) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Add a New Bus");
            System.out.println("2. Register a Passenger");
            System.out.println("3. Book a Ticket");
            System.out.println("4. Track a Bus");
            System.out.println("5. Generate Reports");
            System.out.println("6. Exit");
            
            int choice = InputValidator.getValidInt(scanner, "Enter your choice: ");
            
            switch (choice) {
                case 1:
                    addBus();
                    break;
                case 2:
                    registerPassenger();
                    break;
                case 3:
                    bookTicket();
                    break;
                case 4:
                    trackBus();
                    break;
                case 5:
                    generateReportsMenu();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select from 1-6.");
            }
        }
        scanner.close();
    }

    private static void addBus() {
        System.out.println("\n--- Add a New Bus ---");
        String type = InputValidator.getValidString(scanner, "Enter Bus Type (City, Express, Luxury, School, Tourist, Electric): ").toLowerCase();
        
        // Basic type validation
        if (!type.matches("city|express|luxury|school|tourist|electric")) {
            System.out.println("Error: Invalid bus type.");
            return;
        }

        String vId = InputValidator.getValidString(scanner, "Enter Vehicle ID: ");
        
        // Check duplicate ID
        for (BusManager b : buses) {
            if (b.getVehicleId().equals(vId)) {
                System.out.println("Error: A bus with this ID already exists.");
                return;
            }
        }

        String vName = InputValidator.getValidString(scanner, "Enter Vehicle Name: ");
        int capacity = InputValidator.getValidInt(scanner, "Enter Capacity: ");
        String driverName = InputValidator.getValidString(scanner, "Enter Driver Name: ");
        String busNumber = InputValidator.getValidString(scanner, "Enter Bus Number: ");
        String route = InputValidator.getValidString(scanner, "Enter Assigned Route: ");
        
        String specificAttr = "";
        switch (type) {
            case "city":
                System.out.print("Is it low floor? (true/false): ");
                specificAttr = scanner.nextLine().trim();
                break;
            case "express":
                specificAttr = String.valueOf(InputValidator.getValidInt(scanner, "Enter number of stops: "));
                break;
            case "luxury":
                System.out.print("Does it have WiFi? (true/false): ");
                specificAttr = scanner.nextLine().trim();
                break;
            case "school":
                specificAttr = InputValidator.getValidString(scanner, "Enter School Name: ");
                break;
            case "tourist":
                specificAttr = InputValidator.getValidString(scanner, "Enter Guide Name: ");
                break;
            case "electric":
                specificAttr = String.valueOf(InputValidator.getValidInt(scanner, "Enter Battery Capacity (kWh): "));
                break;
        }

        try {
            BusManager newBus = BusFactory.createBus(type, vId, vName, capacity, driverName, busNumber, route, specificAttr);
            if (newBus != null) {
                buses.add(newBus);
                System.out.println("Bus added successfully! Details: " + newBus.toString());
                newBus.startVehicle(); // Demonstrate abstract method call
            }
        } catch (Exception e) {
            System.out.println("Error creating bus. Please ensure attributes are correct format.");
        }
    }

    private static void registerPassenger() {
        System.out.println("\n--- Register Passenger ---");
        String pId = InputValidator.getValidString(scanner, "Enter Passenger ID: ");
        
        for (Passenger p : passengers) {
            if (p.getPassengerId().equals(pId)) {
                System.out.println("Error: A passenger with this ID already exists.");
                return;
            }
        }

        String name = InputValidator.getValidString(scanner, "Enter Name: ");
        String phone = InputValidator.getValidPhoneNumber(scanner, "Enter Phone Number (10 digits): ");
        String email = InputValidator.getValidEmail(scanner, "Enter Email: ");

        Passenger passenger = new Passenger(pId, name, phone, email);
        passengers.add(passenger);
        System.out.println("Passenger registered successfully: " + passenger.toString());
    }

    private static void bookTicket() {
        System.out.println("\n--- Book a Ticket ---");
        if (buses.isEmpty() || passengers.isEmpty()) {
            System.out.println("Error: Ensure there is at least one bus and one passenger registered before booking.");
            return;
        }

        String pId = InputValidator.getValidString(scanner, "Enter Passenger ID: ");
        Passenger foundPassenger = null;
        for (Passenger p : passengers) {
            if (p.getPassengerId().equals(pId)) {
                foundPassenger = p;
                break;
            }
        }
        if (foundPassenger == null) {
            System.out.println("Error: Passenger ID not found.");
            return;
        }

        System.out.println("Available Buses:");
        for (BusManager b : buses) {
            System.out.println("- " + b.getBusNumber() + " (Route: " + b.getRouteAssigned() + ", Availability: " + b.checkAvailability() + ")");
        }

        String busNum = InputValidator.getValidString(scanner, "Enter Bus Number to book: ");
        BusManager foundBus = null;
        for (BusManager b : buses) {
            if (b.getBusNumber().equals(busNum)) {
                foundBus = b;
                break;
            }
        }
        if (foundBus == null) {
            System.out.println("Error: Bus not found.");
            return;
        }

        if (!foundBus.checkAvailability()) {
            System.out.println("Sorry, this bus is fully booked. Overbooking is not allowed.");
            return;
        }

        double distance = InputValidator.getValidDouble(scanner, "Enter estimated travel distance (km): ");
        
        // Process Booking
        String ticketId = "TKT" + (bookings.size() + 1);
        Ticket ticket = new Ticket(ticketId, foundPassenger, foundBus, foundBus.getSeatsBooked() + 1, distance);
        
        String bookingId = "BKG" + (bookings.size() + 1);
        Booking booking = new Booking(bookingId, foundPassenger, ticket, "Pending");
        
        if (booking.confirmBooking()) {
            System.out.println("Booking Confirmed!");
            System.out.println("Ticket Details: " + ticket.toString());
            
            // Process Payment
            System.out.println("\n--- Processing Payment ---");
            System.out.println("Amount due: $" + String.format("%.2f", ticket.getPrice()));
            String paymentMethod = InputValidator.getValidString(scanner, "Enter Payment Method (Card/Cash): ");
            String paymentId = "PAY" + (payments.size() + 1);
            Payment payment = new Payment(paymentId, ticket.getPrice(), paymentMethod);
            
            if (payment.processPayment()) {
                bookings.add(booking);
                payments.add(payment);
                System.out.println("Payment Status: " + payment.toString());
            } else {
                System.out.println("Payment failed. Cancelling booking.");
                booking.cancelBooking();
            }
        }
    }

    private static void trackBus() {
        System.out.println("\n--- Track Bus ---");
        String busNum = InputValidator.getValidString(scanner, "Enter Bus Number to track: ");
        for (BusManager b : buses) {
            if (b.getBusNumber().equals(busNum)) {
                System.out.println(b.trackLocation());
                return;
            }
        }
        System.out.println("Error: Bus not found.");
    }

    private static void generateReportsMenu() {
        System.out.println("\n--- Reports Menu ---");
        System.out.println("1. Daily Bookings");
        System.out.println("2. Revenue");
        System.out.println("3. Bus Usage");
        System.out.println("4. Passenger Statistics");
        
        int rChoice = InputValidator.getValidInt(scanner, "Select report: ");
        switch (rChoice) {
            case 1:
                ReportGenerator.generateDailyBookingsReport(bookings);
                break;
            case 2:
                ReportGenerator.generateRevenueReport(payments);
                break;
            case 3:
                ReportGenerator.generateBusUsageReport(buses);
                break;
            case 4:
                ReportGenerator.generatePassengerStatistics(passengers);
                break;
            default:
                System.out.println("Invalid report choice.");
        }
    }
}
