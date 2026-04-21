public class CityBus extends BusManager {
    private boolean isLowFloor;

    public CityBus(String vehicleId, String vehicleName, int capacity, String fuelType, String currentLocation, String status,
                   String driverName, String busNumber, String routeAssigned, boolean isLowFloor) {
        super(vehicleId, vehicleName, capacity, fuelType, currentLocation, status, driverName, busNumber, routeAssigned);
        this.isLowFloor = isLowFloor;
        setFareRatePerKm(1.5); // Cheaper fare
    }

    public boolean isLowFloor() { return isLowFloor; }
    public void setLowFloor(boolean isLowFloor) { this.isLowFloor = isLowFloor; }

    @Override
    public double calculateFare(double distance) {
        double fare = super.calculateFare(distance);
        return isLowFloor ? fare * 1.1 : fare; // Slightly more expensive if low floor due to maintenance
    }

    @Override
    public String generateVehicleReport() {
        return "City Bus Report: " + super.generateVehicleReport() + " | Low Floor: " + isLowFloor;
    }

    @Override
    public void startVehicle() {
        System.out.println("City Bus " + getBusNumber() + " is starting for city transit.");
        setStatus("Running - City");
    }

    @Override
    public String toString() {
        return "CityBus: " + super.toString() + " [LowFloor=" + isLowFloor + "]";
    }
}
