package DesignPattern.CreationalDesign.PrototypePattern;

import java.util.List;

/**
 * @author : Kunal Sharma
 * @since : 23/06/24, Sunday
 **/
public class Employee implements Prototype{

    private String name;
    private int age;
    private List<String> skills;

    public Employee(String name, int age, List<String> skills) {
        this.name = name;
        this.age = age;
        this.skills = skills;
    }

    @Override
    public Prototype clone() {
        return new Employee(name, age, skills);
    }
}
