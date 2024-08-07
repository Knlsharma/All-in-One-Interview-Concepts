package DesignPattern.CreationalDesign.AbstractFactoryPattern;

import DesignPattern.CreationalDesign.AbstractFactoryPattern.FactoryImpl.ColourFactory;
import DesignPattern.CreationalDesign.AbstractFactoryPattern.FactoryImpl.ShapeFactory;

/**
 * @author : Kunal Sharma
 * @since : 23/06/24, Sunday
 **/
public class FactoryProducer {
    public static AbstractFactory<?> getFactory(String choice) {
        if (choice.equalsIgnoreCase("SHAPE")) {
            return new ShapeFactory();
        } else if (choice.equalsIgnoreCase("COLOR")) {
            return new ColourFactory();
        }
        return null;
    }
}
