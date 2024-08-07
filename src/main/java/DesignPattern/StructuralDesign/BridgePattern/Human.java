package DesignPattern.StructuralDesign.BridgePattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
class Human extends LivingThing {
    public Human(Movement movement) {
        super(movement);
    }

    @Override
    public void live() {
        System.out.print("Human is ");
        movement.move();
        System.out.println(" on the ground.");
    }
}

