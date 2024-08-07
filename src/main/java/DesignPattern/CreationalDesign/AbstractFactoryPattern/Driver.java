package DesignPattern.CreationalDesign.AbstractFactoryPattern;

import static DesignPattern.CreationalDesign.AbstractFactoryPattern.FactoryProducer.*;

/**
 * @author : Kunal Sharma
 * @since : 23/06/24, Sunday
 **/
public class Driver {
    public static void main(String[] args) {
        AbstractFactory<IShape> IShapeFactory = (AbstractFactory<IShape>) getFactory("IShape");

        // Get an object of IShape Circle
        IShape IShape1 = IShapeFactory.getFromSubFactory("CIRCLE");
        IShape1.draw();

        // Get an object of IShape Square
        IShape IShape2 = IShapeFactory.getFromSubFactory("SQUARE");
        IShape2.draw();

        // Get an object of IShape Rectangle
        IShape IShape3 = IShapeFactory.getFromSubFactory("RECTANGLE");
        IShape3.draw();

        // Get IColour Factory
        AbstractFactory<IColour> IColourFactory = (AbstractFactory<IColour>) getFactory("IColour");

        // Get an object of IColour Red
        IColour IColour1 = IColourFactory.getFromSubFactory("RED");
        IColour1.fill();

        // Get an object of IColour Green
        IColour IColour2 = IColourFactory.getFromSubFactory("GREEN");
        IColour2.fill();

        // Get an object of IColour Blue
        IColour IColour3 = IColourFactory.getFromSubFactory("BLUE");
        IColour3.fill();
    }
}
