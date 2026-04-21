public interface Bookable {
    boolean bookSeat();
    boolean cancelBooking();
    double calculateFare(double distance);
}
