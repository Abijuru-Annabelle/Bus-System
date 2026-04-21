public class Payment {
    private String paymentId;
    private double amount;
    private String paymentMethod;
    private String paymentStatus;

    public Payment(String paymentId, double amount, String paymentMethod) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = "Pending";
    }

    public String getPaymentId() { return paymentId; }
    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }

    public boolean processPayment() {
        // Simulating payment processing
        if (amount > 0) {
            this.paymentStatus = "Completed";
            System.out.println("Payment of $" + amount + " processed successfully via " + paymentMethod);
            return true;
        } else {
            this.paymentStatus = "Failed";
            System.out.println("Payment failed. Invalid amount.");
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("Payment [ID=%s, Amount=$%.2f, Method=%s, Status=%s]", paymentId, amount, paymentMethod, paymentStatus);
    }
}
