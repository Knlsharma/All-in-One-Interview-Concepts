package Java_Concept;

import java.util.Comparator;
import java.util.function.*;

/**
 * @author : Kunal Sharma
 * @since : 27/05/23, Saturday
 **/
public class FunctionalInterfaces {

    @FunctionalInterface
    interface MyFunctionInterface {
        //        void m1();    this is not valid
        int sum(int a, int b);

//        void m18()    this is not valid

        default void defaultM1() {
            System.out.println("Default Method");
        }

        static void staticM1() {
            System.out.println("Static Method");
        }

        String toString(); // object class methods
    }

    interface MyFunctionInterface2 {
        String consume(String a, String b);


        default void defaultM1() {
            System.out.println("Default Method");
        }

        static void staticM1() {
            System.out.println("Static Method");
        }
    }

    /*
    1.) Functional Interface are SAM but can have multiple default and static method.
    2.) Through Lambda Expr. we can represent an Anonymous Function and describe functionality / algo conform to FnI
    3.) For SAM  only we can write Lambda Expr.
    4.) Lambda Expr. () -> {body}
    Anonymous means Nameless
     */


    public static void main(String[] args) {

        Comparable<Integer> comparable2 = new Comparable<Integer>() {
            @Override
            public int compareTo(Integer o) {
                return 0 - o.intValue();
            }
        };

        Comparable<Integer> comparable = o -> 0 - o.intValue(); // compareTo


        Comparator<Integer> comparator2 = new Comparator<Integer>() { // compare
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        Comparator<Integer> comparator = (o1, o2) -> o1.compareTo(o2);

        // Using MyFunctionInterface with a lambda expression
        MyFunctionInterface myFunctionInterface = (a, b) -> a + b;
        System.out.println("Sum: " + myFunctionInterface.sum(1, 2));
        myFunctionInterface.defaultM1();
        MyFunctionInterface.staticM1();

        /******** Predicate *******/
        // bool test(T t)

        // Predicate to check if a number is even
        Predicate<Integer> isEven = (val) -> val % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4));
        System.out.println("Is 5 even? " + isEven.test(5));

        /******** Supplier *******/
        // T get()

        // Supplier to provide a string
        Supplier<String> stringSupplier = () -> "My String";
        System.out.println("Supplier result: " + stringSupplier.get());

        /******** Consumer *******/
        // void accept(T t)

        // Consumer to print a string
        Consumer<String> stringConsumer = (val) -> System.out.println("Consumer value: " + val);
        stringConsumer.accept("my val");

        /******** Function *******/
        // R apply(T t)

        // Function to convert a string to its length
        Function<String, Integer> stringLength = (str) -> str.length();
        System.out.println("Length of 'Hello': " + stringLength.apply("Hello"));

        // Using Method References
        // Method reference to an instance method of an existing object
        Consumer<String> print = System.out::println;
        print.accept("Hello, World!");

        // Method reference to a static method
        Supplier<Double> randomSupplier = Math::random;
        System.out.println("Random number: " + randomSupplier.get());

        // Method reference to an instance method of an arbitrary object of a particular type
        Function<String, Integer> lengthFunction = String::length;
        System.out.println("Length of 'Hello, World!': " + lengthFunction.apply("Hello, World!"));

        // Different ways to write lambda expressions
        Predicate<Integer> isOdd = (val) -> val % 2 != 0;
        System.out.println("Is 3 odd? " + isOdd.test(3));

        // Multi-line lambda expression
        Predicate<Integer> isPositive = (val) -> {
            if (val > 0) {
                return true;
            } else {
                return false;
            }
        };
        System.out.println("Is 5 positive? " + isPositive.test(5));
        System.out.println("Is -3 positive? " + isPositive.test(-3));

        BiFunction<String, String, String> biFunction = (String s1, String s2) -> s1.concat(s2); // algorithm
        MyFunctionInterface2 biFunction2 = (s1, s2) -> s1.concat(s2);

        System.out.println("Bifunction is : " + biFunction.apply("Hello", "World"));
        System.out.println("Bifunction2 is : " + biFunction2.consume("Hello", "World"));
    }

}
