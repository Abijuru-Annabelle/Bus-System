public class Passenger {
    private String passengerId;
    private String name;
    private String phoneNumber;
    private String email;

    public Passenger(String passengerId, String name, String phoneNumber, String email) {
        this.passengerId = passengerId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getPassengerId() { return passengerId; }
    public void setPassengerId(String passengerId) { this.passengerId = passengerId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return String.format("Passenger [ID=%s, Name=%s, Phone=%s, Email=%s]", passengerId, name, phoneNumber, email);
    }
}
