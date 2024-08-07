package DesignPattern.StructuralDesign.BridgePattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
class Bird extends LivingThing {
    public Bird(Movement movement) {
        super(movement);
    }

    @Override
    public void live() {
        System.out.print("Bird is ");
        movement.move();
        System.out.println(" in the sky.");
    }
}
