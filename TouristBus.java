public class TouristBus extends BusManager {
    private String guideName;

    public TouristBus(String vehicleId, String vehicleName, int capacity, String fuelType, String currentLocation, String status,
                      String driverName, String busNumber, String routeAssigned, String guideName) {
        super(vehicleId, vehicleName, capacity, fuelType, currentLocation, status, driverName, busNumber, routeAssigned);
        this.guideName = guideName;
        setFareRatePerKm(4.0); 
    }

    public String getGuideName() { return guideName; }
    public void setGuideName(String guideName) { this.guideName = guideName; }

    @Override
    public double calculateFare(double distance) {
        return super.calculateFare(distance) + 100.0; // Flat guide fee
    }

    @Override
    public String generateVehicleReport() {
        return "Tourist Bus Report: " + super.generateVehicleReport() + " | Guide: " + guideName;
    }

    @Override
    public void startVehicle() {
        System.out.println("Tourist Bus " + getBusNumber() + " is starting with guide " + guideName);
        setStatus("Running - Tourist");
    }

    @Override
    public String toString() {
        return "TouristBus: " + super.toString() + " [Guide=" + guideName + "]";
    }
}
