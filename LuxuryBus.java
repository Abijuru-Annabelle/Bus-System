public class LuxuryBus extends BusManager {
    private boolean hasWiFi;

    public LuxuryBus(String vehicleId, String vehicleName, int capacity, String fuelType, String currentLocation, String status,
                     String driverName, String busNumber, String routeAssigned, boolean hasWiFi) {
        super(vehicleId, vehicleName, capacity, fuelType, currentLocation, status, driverName, busNumber, routeAssigned);
        this.hasWiFi = hasWiFi;
        setFareRatePerKm(5.0); // Premium fare
    }

    public boolean hasWiFi() { return hasWiFi; }
    public void setHasWiFi(boolean hasWiFi) { this.hasWiFi = hasWiFi; }

    @Override
    public double calculateFare(double distance) {
        double fare = super.calculateFare(distance);
        return hasWiFi ? fare + 50.0 : fare; // Flat 50 surcharge for WiFi
    }

    @Override
    public String generateVehicleReport() {
        return "Luxury Bus Report: " + super.generateVehicleReport() + " | WiFi: " + hasWiFi;
    }

    @Override
    public void startVehicle() {
        System.out.println("Luxury Bus " + getBusNumber() + " is starting with premium amenities.");
        setStatus("Running - Luxury");
    }

    @Override
    public String toString() {
        return "LuxuryBus: " + super.toString() + " [WiFi=" + hasWiFi + "]";
    }
}
