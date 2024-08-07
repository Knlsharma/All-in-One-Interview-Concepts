package DesignPattern.BehaviouralDesign.StatePattern;

/**
 * @author : Kunal Sharma
 * @since : 15/07/24, Monday
 **/
public class Driver {

    public static void main(String[] args) {
    VendingMachine vendingMachine = new VendingMachine();

    // Insert coin and select product
        vendingMachine.insertCoin(10);
        vendingMachine.selectProduct(1);
        vendingMachine.dispenseProduct();

    // Insert more coins and select another product
        vendingMachine.insertCoin(5);
        vendingMachine.selectProduct(2);
        vendingMachine.dispenseProduct();
    }

}
