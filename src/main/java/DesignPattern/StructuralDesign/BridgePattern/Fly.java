package DesignPattern.StructuralDesign.BridgePattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class Fly implements Movement {
    @Override
    public void move() {
        System.out.println("Flying");
    }
}
