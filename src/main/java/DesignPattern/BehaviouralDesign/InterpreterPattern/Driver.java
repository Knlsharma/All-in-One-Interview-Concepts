package DesignPattern.BehaviouralDesign.InterpreterPattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class Driver {
    public static void main(String[] args) {

        Expression number5 = new NumberExpression(5);
        Expression number8 = new NumberExpression(8);
        Expression number2 = new NumberExpression(2);

        Expression subtraction = new SubtractionExpression(number8, number2);
        Expression addition = new AdditionExpression(number5, subtraction);

        // Evaluate the expression
        int result = addition.interpret();
        System.out.println("Result: " + result); // Output:
    }
}
