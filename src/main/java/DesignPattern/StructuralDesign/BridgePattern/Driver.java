package DesignPattern.StructuralDesign.BridgePattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class Driver {
    public static void main(String[] args) {
        LivingThing bird = new Bird(new Fly());
        LivingThing human = new Human(new Walk());

        bird.live();
        human.live();
    }
}
