package DesignPattern.BehaviouralDesign.TemplatePattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class CreditCardPaymentProcessor extends AbstractPaymentProcessor {

    private String cardNumber;
    private String expiryDate;
    private String cvv;

    public CreditCardPaymentProcessor(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    void performPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount + " using card number " + cardNumber);
        // Logic to connect with payment gateway and complete credit card payment
    }

    @Override
    void notifyCustomer() {
        System.out.println("Sending email receipt to customer for credit card payment");
    }
}