package DesignPattern.StructuralDesign.DecoratorPattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class Driver {
    public static void main(String[] args) {
        Pizza basicPizza = new PlainPizza();
        System.out.println("Plain pizza:");
        System.out.println("Description: " + basicPizza.getDescription());
        System.out.println("Cost: $" + basicPizza.getCost());

        // Add extra cheese
        Pizza cheesePizza = new CheeseDecorator(basicPizza);
        System.out.println("\nCheese pizza:");
        System.out.println("Description: " + cheesePizza.getDescription());
        System.out.println("Cost: $" + cheesePizza.getCost());

        // Add pepperoni on top of cheese pizza
        Pizza deluxePizza = new PepperoniDecorator(cheesePizza);
        System.out.println("\nDeluxe pizza:");
        System.out.println("Description: " + deluxePizza.getDescription());
        System.out.println("Cost: $" + deluxePizza.getCost());
    }
}
