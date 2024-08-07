package DesignPattern.CreationalDesign.PrototypePattern;

import java.util.Arrays;

/**
 * @author : Kunal Sharma
 * @since : 23/06/24, Sunday
 **/
public class Driver {
    public static void main(String[] args) {

         Student student = new Student("Kunal", 23, Arrays.asList("Java", "C++"));
         Student studentClone = (Student) student.clone();

        System.out.println(student.hashCode());
        System.out.println(studentClone.hashCode());
    }
}
