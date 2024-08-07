package DesignPattern.BehaviouralDesign.StrategyPattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class Driver {
    public static void main(String[] args) {
        // Creating a payment context
        PaymentContext paymentContext = new PaymentContext();

        // Paying via UPI
        String upiId = "example@upi";
        IPaymentStrategy upiPayment = new UpiPaymentStrategy(upiId);
        paymentContext.setPaymentStrategy(upiPayment);
        paymentContext.executePayment(1000.0);

        // Paying via Debit Card
        String cardNumber = "1234 5678 9012 3456";
        String expiryDate = "12/24";
        String cvv = "123";
        IPaymentStrategy debitCardPayment = new DebitCardPaymentStrategy(cardNumber, expiryDate, cvv);
        paymentContext.setPaymentStrategy(debitCardPayment);
        paymentContext.executePayment(2500.0);
    }
}
