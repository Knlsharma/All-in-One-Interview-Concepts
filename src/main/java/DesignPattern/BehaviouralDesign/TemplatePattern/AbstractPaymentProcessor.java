package DesignPattern.BehaviouralDesign.TemplatePattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public abstract class AbstractPaymentProcessor {

    // Template method defining the payment processing flow
    public final void processPayment(double amount) {
        authenticate();
        validate();
        performPayment(amount);
        notifyCustomer();
    }

    // Abstract methods to be implemented by subclasses
    abstract void performPayment(double amount);
    abstract void notifyCustomer();

    // Concrete methods
    void authenticate() {
        System.out.println("Authenticating user");
    }

    void validate() {
        System.out.println("Validating payment details");
    }
}
