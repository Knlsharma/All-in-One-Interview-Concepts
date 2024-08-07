package DesignPattern.CreationalDesign.AbstractFactoryPattern;

/**
 * @author : Kunal Sharma
 * @since : 23/06/24, Sunday
 **/
public interface AbstractFactory<T> {
    T getFromSubFactory(String type);
}
