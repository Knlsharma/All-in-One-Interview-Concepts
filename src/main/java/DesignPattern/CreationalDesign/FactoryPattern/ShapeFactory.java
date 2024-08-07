package DesignPattern.CreationalDesign.FactoryPattern;

import DesignPattern.CreationalDesign.FactoryPattern.ShapeImpl.Circle;
import DesignPattern.CreationalDesign.FactoryPattern.ShapeImpl.Square;
import DesignPattern.CreationalDesign.FactoryPattern.ShapeImpl.Rectangle;

/**
 * @author : Kunal Sharma
 * @since : 23/06/24, Sunday
 **/
public class ShapeFactory {
    // Use getShape method to get an object of type Shape
    public Shape getShape(String shapeType) {
        if (shapeType == null) {
            return null;
        }
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}
