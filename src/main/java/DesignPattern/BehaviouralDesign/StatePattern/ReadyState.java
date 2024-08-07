package DesignPattern.BehaviouralDesign.StatePattern;

/**
 * @author : Kunal Sharma
 * @since : 15/07/24, Monday
 **/
public class ReadyState implements IVendingMachineState {

    private VendingMachine vendingMachine;

    public ReadyState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void insertCoin(int amount) {
        vendingMachine.addAmount(amount);
    }

    @Override
    public void selectProduct(int productId) {
        vendingMachine.setSelectedProduct(productId);
        vendingMachine.changeState(new ProductSelectedState(vendingMachine));
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please select a product first");
    }
}
