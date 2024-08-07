package DesignPattern.StructuralDesign.DecoratorPattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
class CheeseDecorator extends PizzaDecorator {
    public CheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", extra cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.5;
    }
}
