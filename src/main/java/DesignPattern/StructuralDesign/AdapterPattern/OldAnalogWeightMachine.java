package DesignPattern.StructuralDesign.AdapterPattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class OldAnalogWeightMachine implements AnalogWeightMachine {
    @Override
    public void measureWeightInPounds() {
        double weight = Math.random() * 100; // Simulate random weight in pounds
        System.out.println("Measured weight in pounds: " + weight);
    }
}
