package DesignPattern.CreationalDesign.AbstractFactoryPattern.FactoryImpl;

import DesignPattern.CreationalDesign.AbstractFactoryPattern.AbstractFactory;
import DesignPattern.CreationalDesign.AbstractFactoryPattern.ColourImpl.Blue;
import DesignPattern.CreationalDesign.AbstractFactoryPattern.ColourImpl.Green;
import DesignPattern.CreationalDesign.AbstractFactoryPattern.ColourImpl.Red;
import DesignPattern.CreationalDesign.AbstractFactoryPattern.IColour;

/**
 * @author : Kunal Sharma
 * @since : 23/06/24, Sunday
 **/
public class ColourFactory implements AbstractFactory<IColour> {

    public IColour getFromSubFactory(String colorType) {
        if (colorType == null) {
            return null;
        }
        if (colorType.equalsIgnoreCase("RED")) {
            return new Red();
        } else if (colorType.equalsIgnoreCase("GREEN")) {
            return new Green();
        } else if (colorType.equalsIgnoreCase("BLUE")) {
            return new Blue();
        }
        return null;
    }
}
