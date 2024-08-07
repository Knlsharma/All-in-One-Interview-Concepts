package DesignPattern.BehaviouralDesign.StrategyPattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class DebitCardPaymentStrategy implements IPaymentStrategy {

    private String cardNumber;
    private String expiryDate;
    private String cvv;

    public DebitCardPaymentStrategy(String cardNumber, String expiryDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expiryDate = expiryDate;
        this.cvv = cvv;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " via Debit Card with card number: " + cardNumber);
        // Logic to connect with payment gateway and complete payment
    }
}
