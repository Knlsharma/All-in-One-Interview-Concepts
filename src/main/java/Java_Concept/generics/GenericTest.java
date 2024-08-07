package Java_Concept.generics;

import java.util.List;

/**
 * @author : Kunal Sharma
 * @since : 27/07/24, Saturday
 **/
public class GenericTest<T> { // apart from primitives it can be anything

        T value;

    public GenericTest() {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public <T extends Number> void computeList(List<T> source, List<T> dest) { // expect same type

    }

    public static void main(String[] args) {

        GenericTest<Integer> integerGenericTest = new GenericTest<Integer>();
        integerGenericTest.setValue(1);
        Integer values = integerGenericTest.getValue();
        System.out.println(values);

        GenericTest generic = new GenericTest(); // raw type
        generic.setValue("1");



    }
}
