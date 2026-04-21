public class ExpressBus extends BusManager {
    private int numberOfStops;

    public ExpressBus(String vehicleId, String vehicleName, int capacity, String fuelType, String currentLocation, String status,
                      String driverName, String busNumber, String routeAssigned, int numberOfStops) {
        super(vehicleId, vehicleName, capacity, fuelType, currentLocation, status, driverName, busNumber, routeAssigned);
        this.numberOfStops = numberOfStops;
        setFareRatePerKm(3.0); // More expensive fare
    }

    public int getNumberOfStops() { return numberOfStops; }
    public void setNumberOfStops(int numberOfStops) { this.numberOfStops = numberOfStops; }

    @Override
    public double calculateFuelConsumption(double distance) {
        return distance * 0.25; // Express buses have better mileage due to fewer stops
    }

    @Override
    public String generateVehicleReport() {
        return "Express Bus Report: " + super.generateVehicleReport() + " | Stops: " + numberOfStops;
    }

    @Override
    public void startVehicle() {
        System.out.println("Express Bus " + getBusNumber() + " is starting express route.");
        setStatus("Running - Express");
    }

    @Override
    public String toString() {
        return "ExpressBus: " + super.toString() + " [Stops=" + numberOfStops + "]";
    }
}
