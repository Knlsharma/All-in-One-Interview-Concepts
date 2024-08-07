package Java_Concept.generics;

/**
 * @author : Kunal Sharma
 * @since : 27/07/24, Saturday
 **/
public class ColorPrintSubClass extends GenericTest<String> { // string type

    public static void main(String[] args) {

        GenericTest<String> parentSubClass = new ColorPrintSubClass();
        parentSubClass.setValue("hi");
        System.out.println(getValue("hi")); // calling only generic method

    }

    public static <T> T getValue(T value) {
        return value;
    }


}
