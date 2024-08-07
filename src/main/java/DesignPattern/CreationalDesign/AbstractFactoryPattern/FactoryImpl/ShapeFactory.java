package DesignPattern.CreationalDesign.AbstractFactoryPattern.FactoryImpl;

import DesignPattern.CreationalDesign.AbstractFactoryPattern.AbstractFactory;
import DesignPattern.CreationalDesign.AbstractFactoryPattern.IShape;
import DesignPattern.CreationalDesign.AbstractFactoryPattern.ShapeImpl.Circle;
import DesignPattern.CreationalDesign.AbstractFactoryPattern.ShapeImpl.Rectangle;
import DesignPattern.CreationalDesign.AbstractFactoryPattern.ShapeImpl.Square;

/**
 * @author : Kunal Sharma
 * @since : 23/06/24, Sunday
 **/
public class ShapeFactory implements AbstractFactory<IShape> {
    @Override
    public IShape getFromSubFactory(String shapeType) {
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
