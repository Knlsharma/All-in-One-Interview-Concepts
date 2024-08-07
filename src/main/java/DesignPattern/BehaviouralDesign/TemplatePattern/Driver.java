package DesignPattern.BehaviouralDesign.TemplatePattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class Driver {
    public static void main(String[] args) {
        String cardNumber = "1234 5678 9012 3456";
        String expiryDate = "12/24";
        String cvv = "123";
        AbstractPaymentProcessor creditCardProcessor = new CreditCardPaymentProcessor(cardNumber, expiryDate, cvv);
        creditCardProcessor.processPayment(500.0);

        System.out.println();

        // Processing UPI payment
        String upiId = "example@upi";
        AbstractPaymentProcessor upiProcessor = new UPIPaymentProcessor(upiId);
        upiProcessor.processPayment(300.0);

    }
}
