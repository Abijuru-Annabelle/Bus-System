public class Driver {
    private String driverId;
    private String name;
    private String licenseNumber;
    private int experienceYears;

    public Driver(String driverId, String name, String licenseNumber, int experienceYears) {
        this.driverId = driverId;
        this.name = name;
        this.licenseNumber = licenseNumber;
        this.experienceYears = experienceYears;
    }

    public String getDriverId() { return driverId; }
    public void setDriverId(String driverId) { this.driverId = driverId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getLicenseNumber() { return licenseNumber; }
    public void setLicenseNumber(String licenseNumber) { this.licenseNumber = licenseNumber; }

    public int getExperienceYears() { return experienceYears; }
    public void setExperienceYears(int experienceYears) { this.experienceYears = experienceYears; }

    @Override
    public String toString() {
        return String.format("Driver [ID=%s, Name=%s, License=%s, Experience=%d years]", driverId, name, licenseNumber, experienceYears);
    }
}
