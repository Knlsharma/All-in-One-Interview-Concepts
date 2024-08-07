package DesignPattern.StructuralDesign.BridgePattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
abstract class LivingThing {
    protected Movement movement;

    public LivingThing(Movement movement) {
        this.movement = movement;
    }

    public abstract void live();
}

