public class Ticket {
    private String ticketId;
    private Passenger passenger;
    private BusManager bus;
    private int seatNumber;
    private double price;

    public Ticket(String ticketId, Passenger passenger, BusManager bus, int seatNumber, double distance) {
        this.ticketId = ticketId;
        this.passenger = passenger;
        this.bus = bus;
        this.seatNumber = seatNumber;
        this.price = calculateTicketPrice(distance);
    }

    public String getTicketId() { return ticketId; }
    public void setTicketId(String ticketId) { this.ticketId = ticketId; }

    public Passenger getPassenger() { return passenger; }
    public void setPassenger(Passenger passenger) { this.passenger = passenger; }

    public BusManager getBus() { return bus; }
    public void setBus(BusManager bus) { this.bus = bus; }

    public int getSeatNumber() { return seatNumber; }
    public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public double calculateTicketPrice(double distance) {
        return bus.calculateFare(distance);
    }

    @Override
    public String toString() {
        return String.format("Ticket [ID=%s, Passenger=%s, Bus=%s, Seat=%d, Price=$%.2f]", 
                ticketId, passenger.getName(), bus.getBusNumber(), seatNumber, price);
    }
}
