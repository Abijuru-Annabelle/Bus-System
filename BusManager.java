public class BusManager extends Vehicle implements Bookable, Trackable {
    private String driverName;
    private String busNumber;
    private String routeAssigned;
    private int seatsBooked;
    private double fareRatePerKm;

    

    public BusManager(String vehicleId, String vehicleName, int capacity, String fuelType, String currentLocation, String status,
                      String driverName, String busNumber, String routeAssigned) {
        super(vehicleId, vehicleName, capacity, fuelType, currentLocation, status);
        this.driverName = driverName;
        this.busNumber = busNumber;
        this.routeAssigned = routeAssigned;
        this.seatsBooked = 0;
        this.fareRatePerKm = 2.5;
    }

    public String getDriverName() { return driverName; }
    public void setDriverName(String driverName) { this.driverName = driverName; }

    public String getBusNumber() { return busNumber; }
    public void setBusNumber(String busNumber) { this.busNumber = busNumber; }

    public String getRouteAssigned() { return routeAssigned; }
    public void setRouteAssigned(String routeAssigned) { this.routeAssigned = routeAssigned; }

    public int getSeatsBooked() { return seatsBooked; }
    public void setSeatsBooked(int seatsBooked) { this.seatsBooked = seatsBooked; }
    
    public double getFareRatePerKm() { return fareRatePerKm; }
    public void setFareRatePerKm(double fareRatePerKm) { this.fareRatePerKm = fareRatePerKm; }

    @Override
    public void startVehicle() {
        System.out.println("BusManager " + busNumber + " is starting the engine.");
        setStatus("Running");
    }

    @Override
    public void stopVehicle() {
        System.out.println("BusManager " + busNumber + " has stopped.");
        setStatus("Stopped");
    }

    @Override
    public double calculateFuelConsumption(double distance) {
        return distance * 0.3; // Assuming 0.3 liters per km
    }

    @Override
    public boolean checkAvailability() {
        return seatsBooked < getCapacity();
    }

    @Override
    public void assignRoute(String routeName) {
        this.routeAssigned = routeName;
        System.out.println("Route " + routeName + " assigned to bus " + busNumber);
    }

    @Override
    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
    }

    @Override
    public boolean performMaintenanceCheck() {
        System.out.println("Maintenance check passed for " + busNumber);
        return true;
    }

    @Override
    public String generateVehicleReport() {
        return "Report for Bus " + busNumber + ": " + getSeatsBooked() + "/" + getCapacity() + " seats booked. Route: " + routeAssigned;
    }

    @Override
    public boolean bookSeat() {
        if (checkAvailability()) {
            seatsBooked++;
            return true;
        }
        return false;
    }

    @Override
    public boolean cancelBooking() {
        if (seatsBooked > 0) {
            seatsBooked--;
            return true;
        }
        return false;
    }

    @Override
    public double calculateFare(double distance) {
        return distance * fareRatePerKm;
    }

    @Override
    public String trackLocation() {
        return "Bus " + busNumber + " is currently at " + getCurrentLocation();
    }

    @Override
    public void updateStatus(String newStatus) {
        setStatus(newStatus);
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" [Bus#=%s, Driver=%s, Route=%s, Booked=%d/%d]",
                busNumber, driverName, routeAssigned, seatsBooked, getCapacity());
    }
}
