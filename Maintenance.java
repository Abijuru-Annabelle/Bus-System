import java.util.Date;

public class Maintenance {
    private String maintenanceId;
    private Vehicle vehicle;
    private Date maintenanceDate;
    private String description;

    public Maintenance(String maintenanceId, Vehicle vehicle, String description) {
        this.maintenanceId = maintenanceId;
        this.vehicle = vehicle;
        this.description = description;
    }

    public String getMaintenanceId() { return maintenanceId; }
    public void setMaintenanceId(String maintenanceId) { this.maintenanceId = maintenanceId; }

    public Vehicle getVehicle() { return vehicle; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }

    public Date getMaintenanceDate() { return maintenanceDate; }
    public void setMaintenanceDate(Date maintenanceDate) { this.maintenanceDate = maintenanceDate; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public void scheduleMaintenance(Date date) {
        this.maintenanceDate = date;
        vehicle.setStatus("In Maintenance");
        System.out.println("Maintenance scheduled for vehicle " + vehicle.getVehicleId() + " on " + date.toString());
    }

    @Override
    public String toString() {
        return String.format("Maintenance [ID=%s, Vehicle=%s, Date=%s, Desc=%s]", 
                maintenanceId, vehicle.getVehicleId(), (maintenanceDate != null ? maintenanceDate.toString() : "Not Scheduled"), description);
    }
}
