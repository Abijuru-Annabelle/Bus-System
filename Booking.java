import java.util.Date;

public class Booking {
    private String bookingId;
    private Passenger passenger;
    private Ticket ticket;
    private Date bookingDate;
    private String status;
    
    public Booking(String bookingId, Passenger passenger, Ticket ticket, String status) {
        this.bookingId = bookingId;
        this.passenger = passenger;
        this.ticket = ticket;
        this.bookingDate = new Date();
        this.status = status;
    }

    public String getBookingId() { return bookingId; }
    public void setBookingId(String bookingId) { this.bookingId = bookingId; }

    public Passenger getPassenger() { return passenger; }
    public void setPassenger(Passenger passenger) { this.passenger = passenger; }

    public Ticket getTicket() { return ticket; }
    public void setTicket(Ticket ticket) { this.ticket = ticket; }

    public Date getBookingDate() { return bookingDate; }
    public void setBookingDate(Date bookingDate) { this.bookingDate = bookingDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public boolean confirmBooking() {
        if (ticket.getBus().bookSeat()) {
            this.status = "Confirmed";
            return true;
        } else {
            this.status = "Failed - Bus Full";
            return false;
        }
    }

    public void cancelBooking() {
        if (ticket.getBus().cancelBooking()) {
            this.status = "Cancelled";
        }
    }

    @Override
    public String toString() {
        return String.format("Booking [ID=%s, Passenger=%s, Date=%s, Status=%s]", 
                bookingId, passenger.getName(), bookingDate.toString(), status);
    }
}
