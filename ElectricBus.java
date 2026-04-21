public class ElectricBus extends BusManager {
    private int batteryCapacity; 

    public ElectricBus(String vehicleId, String vehicleName, int capacity, String currentLocation, String status,
                       String driverName, String busNumber, String routeAssigned, int batteryCapacity) {
        super(vehicleId, vehicleName, capacity, "Electric", currentLocation, status, driverName, busNumber, routeAssigned);
        this.batteryCapacity = batteryCapacity;
        setFareRatePerKm(2.0);
    }

    public int getBatteryCapacity() { return batteryCapacity; }
    public void setBatteryCapacity(int batteryCapacity) { this.batteryCapacity = batteryCapacity; }

    @Override
    public double calculateFuelConsumption(double distance) {
        return distance * 1.5; 
    }

    @Override
    public String generateVehicleReport() {
        return "Electric Bus Report: " + super.generateVehicleReport() + " | Battery: " + batteryCapacity + "kWh";
    }

    @Override
    public void startVehicle() {
        System.out.println("Electric Bus " + getBusNumber() + " is silently starting.");
        setStatus("Running - Electric");
    }

    @Override
    public String toString() {
        return "ElectricBus: " + super.toString() + " [Battery=" + batteryCapacity + "kWh]";
    }
}
