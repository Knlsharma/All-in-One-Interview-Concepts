package DesignPattern.CreationalDesign.AbstractFactoryPattern.ShapeImpl;

import DesignPattern.CreationalDesign.AbstractFactoryPattern.IShape;

/**
 * @author : Kunal Sharma
 * @since : 23/06/24, Sunday
 **/
public class Circle implements IShape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
