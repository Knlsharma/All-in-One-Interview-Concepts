package DesignPattern.CreationalDesign.FactoryPattern.ShapeImpl;

import DesignPattern.CreationalDesign.FactoryPattern.Shape;

/**
 * @author : Kunal Sharma
 * @since : 23/06/24, Sunday
 **/
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
