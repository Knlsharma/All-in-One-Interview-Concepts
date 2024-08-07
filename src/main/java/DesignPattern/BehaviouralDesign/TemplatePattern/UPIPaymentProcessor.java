package DesignPattern.BehaviouralDesign.TemplatePattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class UPIPaymentProcessor extends AbstractPaymentProcessor {

    private String upiId;

    public UPIPaymentProcessor(String upiId) {
        this.upiId = upiId;
    }

    @Override
    void performPayment(double amount) {
        System.out.println("Processing UPI payment of $" + amount + " using UPI ID " + upiId);
        // Logic to connect with UPI payment gateway and complete UPI payment
    }

    @Override
    void notifyCustomer() {
        System.out.println("Sending SMS notification to customer for UPI payment");
    }
}
