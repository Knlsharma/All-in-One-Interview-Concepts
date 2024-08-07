package DesignPattern.StructuralDesign.BridgePattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class Walk implements Movement {
    @Override
    public void move() {
        System.out.println("Walking");
    }
}