import java.util.List;

public class ReportGenerator {

    public static void generateDailyBookingsReport(List<Booking> bookings) {
        System.out.println("\n--- Daily Bookings Report ---");
        int totalBookings = bookings.size();
        int confirmed = 0;
        int cancelled = 0;
        
        for (Booking b : bookings) {
            System.out.println(b.toString());
            if (b.getStatus().equals("Confirmed")) confirmed++;
            else if (b.getStatus().equals("Cancelled")) cancelled++;
        }
        
        System.out.println("Total Bookings: " + totalBookings);
        System.out.println("Confirmed: " + confirmed);
        System.out.println("Cancelled: " + cancelled);
        System.out.println("-----------------------------");
    }

    public static void generateRevenueReport(List<Payment> payments) {
        System.out.println("\n--- Revenue Report ---");
        double totalRevenue = 0;
        for (Payment p : payments) {
            if (p.getPaymentStatus().equals("Completed")) {
                totalRevenue += p.getAmount();
            }
        }
        System.out.println("Total Revenue Generated: $" + String.format("%.2f", totalRevenue));
        System.out.println("----------------------");
    }

    public static void generateBusUsageReport(List<BusManager> buses) {
        System.out.println("\n--- Bus Usage Report ---");
        for (BusManager bus : buses) {
            System.out.println(bus.generateVehicleReport());
        }
        System.out.println("------------------------");
    }

    public static void generatePassengerStatistics(List<Passenger> passengers) {
        System.out.println("\n--- Passenger Statistics ---");
        System.out.println("Total Registered Passengers: " + passengers.size());
        for (Passenger p : passengers) {
            System.out.println(p.getName() + " (ID: " + p.getPassengerId() + ")");
        }
        System.out.println("----------------------------");
    }
}
