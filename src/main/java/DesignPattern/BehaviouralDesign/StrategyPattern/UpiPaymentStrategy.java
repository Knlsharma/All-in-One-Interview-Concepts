package DesignPattern.BehaviouralDesign.StrategyPattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class UpiPaymentStrategy  implements IPaymentStrategy {

    private String upiId;

    public UpiPaymentStrategy(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " via UPI using UPI ID: " + upiId);
        // Logic to connect with UPI payment gateway and complete payment
    }
}
