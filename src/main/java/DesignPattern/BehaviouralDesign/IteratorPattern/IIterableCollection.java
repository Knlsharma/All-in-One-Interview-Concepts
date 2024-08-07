package DesignPattern.BehaviouralDesign.IteratorPattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public interface IIterableCollection<T> {
    IIterator<T> iterator();
}