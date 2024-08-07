package Java_Concept.generics;

import java.util.List;

/**
 * @author : Kunal Sharma
 * @since : 27/07/24, Saturday
 **/
public class BoundedGeneric<T extends Number> {

    // 1.) upper bound --> restricting behaviour like Number and child : < T extends Number >
    // 2.) multi bound --> < T extends ParentClass & Interface1 & Interface2 > in this ParentClass is concrete class

    // Wildcard
    // 1.) upper bound --> class name and below < ? extends UpperBoundClassName >
    // 2.) lower bound --> class name and above < ? super LowerBoundClassName >
    // 3.) unbounded wildcard --> <?> only you can read
    public void computeList(List<? extends Number> source, List<? extends Number> dest) {
    // provides super also
    }


    public static void main(String[] args) {
//      1.)
        BoundedGeneric<Integer> sample = new BoundedGeneric<>();
//      2.)

    }
}
