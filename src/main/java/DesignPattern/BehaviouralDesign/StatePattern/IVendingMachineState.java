package DesignPattern.BehaviouralDesign.StatePattern;

/**
 * @author : Kunal Sharma
 * @since : 15/07/24, Monday
 **/
public interface IVendingMachineState {
    void insertCoin(int amount);
    void selectProduct(int productId);
    void dispenseProduct();
}
