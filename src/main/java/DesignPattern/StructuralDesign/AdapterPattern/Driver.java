package DesignPattern.StructuralDesign.AdapterPattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class Driver {
    public static void main(String[] args) {
        WeightMachine analogWeightMachineAdapter = new WeightMachineAdapter(new OldAnalogWeightMachine());
        WeightMachine digitalWeightMachineAdapter = new WeightMachineAdapter(new ModernDigitalWeightMachine());

        // Measure weight using adapters
        System.out.println("Using Analog Weight Machine Adapter:");
        analogWeightMachineAdapter.measureWeight();

        System.out.println("\nUsing Digital Weight Machine Adapter:");
        digitalWeightMachineAdapter.measureWeight();
    }
}
