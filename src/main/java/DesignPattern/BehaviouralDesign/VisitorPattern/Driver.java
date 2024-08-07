package DesignPattern.BehaviouralDesign.VisitorPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class Driver {
    private List<Object> roomObjects;

    public Driver() {
        roomObjects = new ArrayList<>();
        roomObjects.add(new Chair());
        roomObjects.add(new Bed());
        roomObjects.add(new Table());
    }

    public void accept(IVisitor visitor) {
        for (Object object : roomObjects) {
            if (object instanceof Chair) {
                ((Chair) object).accept(visitor);
            } else if (object instanceof Bed) {
                ((Bed) object).accept(visitor);
            } else if (object instanceof Table) {
                ((Table) object).accept(visitor);
            }
        }
    }

    public static void main(String[] args) {
        Driver room = new Driver();

        // Inspector visiting the room
        System.out.println("Inspector is inspecting the room:");
        room.accept(new Inspector());

        System.out.println();

        // Cleaner visiting the room
        System.out.println("Cleaner is cleaning the room:");
        room.accept(new Cleaner());
    }
}
