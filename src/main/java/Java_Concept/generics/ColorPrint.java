package Java_Concept.generics;

/**
 * @author : Kunal Sharma
 * @since : 27/07/24, Saturday
 **/
public class ColorPrint<T> extends GenericTest<T> {
    public static void main(String[] args) {
        GenericTest<Integer> parentSubClass = new ColorPrint(); // telling at compile time
        parentSubClass.setValue(22);

    }
}
