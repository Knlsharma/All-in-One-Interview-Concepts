package DesignPattern.CreationalDesign.AbstractFactoryPattern.ColourImpl;

import DesignPattern.CreationalDesign.AbstractFactoryPattern.IColour;

/**
 * @author : Kunal Sharma
 * @since : 23/06/24, Sunday
 **/
public class Green implements IColour {
    @Override
    public void fill() {
        System.out.println("Filling with Green color");
    }
}
