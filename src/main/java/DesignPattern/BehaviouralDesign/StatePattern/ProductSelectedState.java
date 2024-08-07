package DesignPattern.BehaviouralDesign.StatePattern;

/**
 * @author : Kunal Sharma
 * @since : 15/07/24, Monday
 **/
public class ProductSelectedState implements IVendingMachineState {
    private VendingMachine vendingMachine;

    public ProductSelectedState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(int amount) {
        vendingMachine.addAmount(amount);
    }

    @Override
    public void selectProduct(int productId) {
        System.out.println("Please wait, dispensing current product");
    }

    @Override
    public void dispenseProduct() {
        if (vendingMachine.canDispenseProduct()) {
            vendingMachine.dispenseProduct();
            vendingMachine.changeState(new ReadyState(vendingMachine));
        } else {
            System.out.println("Insufficient amount. Please insert more coins.");
        }
    }
}
