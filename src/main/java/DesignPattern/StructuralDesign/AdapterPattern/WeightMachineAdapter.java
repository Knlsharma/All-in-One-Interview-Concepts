package DesignPattern.StructuralDesign.AdapterPattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class WeightMachineAdapter implements WeightMachine {
    private AnalogWeightMachine analogWeightMachine;
    private DigitalWeightMachine digitalWeightMachine;

    public WeightMachineAdapter(AnalogWeightMachine analogWeightMachine) {
        this.analogWeightMachine = analogWeightMachine;
    }

    public WeightMachineAdapter(DigitalWeightMachine digitalWeightMachine) {
        this.digitalWeightMachine = digitalWeightMachine;
    }

    @Override
    public void measureWeight() {
        if (analogWeightMachine != null) {
            analogWeightMachine.measureWeightInPounds();
        } else if (digitalWeightMachine != null) {
            digitalWeightMachine.measureWeightInKilograms();
        }
    }
}