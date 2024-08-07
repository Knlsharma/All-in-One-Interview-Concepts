package DesignPattern.BehaviouralDesign.StatePattern;

/**
 * @author : Kunal Sharma
 * @since : 15/07/24, Monday
 **/

public class VendingMachine {

    private IVendingMachineState currentState;
    private int amount;
    private int selectedProduct;

    public VendingMachine() {
        currentState = new ReadyState(this);
        amount = 0;
        selectedProduct = -1;
    }

    public void setCurrentState(IVendingMachineState currentState) {
        this.currentState = currentState;
    }

    public void addAmount(int amount) {
        this.amount += amount;
        System.out.println("Amount inserted: " + amount);
    }

    public void setSelectedProduct(int productId) {
        this.selectedProduct = productId;
        System.out.println("Product selected: " + productId);
    }

    public void changeState(IVendingMachineState newState) {
        this.currentState = newState;
    }

    public void dispenseProduct() {
        System.out.println("Product dispensed: " + selectedProduct);
        amount -= 10; // Assuming product price is 10 units
        System.out.println("Amount left: " + amount);
    }

    public boolean canDispenseProduct() {
        return amount >= 10; // Assuming product price is 10 units
    }

    public void insertCoin(int amount) {
        currentState.insertCoin(amount);
    }

    public void selectProduct(int productId) {
        currentState.selectProduct(productId);
    }


}
