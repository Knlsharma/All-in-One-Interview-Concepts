package DesignPattern.BehaviouralDesign.IteratorPattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public interface IIterator<T> {
    boolean hasNext();
    T next();
}
