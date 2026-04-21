public class SchoolBus extends BusManager {
    private String schoolName;

    public SchoolBus(String vehicleId, String vehicleName, int capacity, String fuelType, String currentLocation, String status,
                     String driverName, String busNumber, String routeAssigned, String schoolName) {
        super(vehicleId, vehicleName, capacity, fuelType, currentLocation, status, driverName, busNumber, routeAssigned);
        this.schoolName = schoolName;
        setFareRatePerKm(1.0); // Student rate
    }

    public String getSchoolName() { return schoolName; }
    public void setSchoolName(String schoolName) { this.schoolName = schoolName; }

    @Override
    public double calculateFare(double distance) {
        return 0; // School buses typically have pre-paid term passes, single trip fare is 0
    }

    @Override
    public String generateVehicleReport() {
        return "School Bus Report: " + super.generateVehicleReport() + " | School: " + schoolName;
    }

    @Override
    public void startVehicle() {
        System.out.println("School Bus " + getBusNumber() + " is starting for " + schoolName);
        setStatus("Running - School");
    }

    @Override
    public String toString() {
        return "SchoolBus: " + super.toString() + " [School=" + schoolName + "]";
    }
}
