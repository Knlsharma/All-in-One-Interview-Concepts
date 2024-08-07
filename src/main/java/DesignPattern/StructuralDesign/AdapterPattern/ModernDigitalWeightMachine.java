package DesignPattern.StructuralDesign.AdapterPattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class ModernDigitalWeightMachine implements DigitalWeightMachine {
    @Override
    public void measureWeightInKilograms() {
        double weight = Math.random() * 50; // Simulate random weight in kilograms
        System.out.println("Measured weight in kilograms: " + weight);
    }
}
