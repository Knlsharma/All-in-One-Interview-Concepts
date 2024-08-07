package Java_Concept;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : Kunal Sharma
 * @since : 14/07/24, Sunday
 **/

public final class PointImmutableClass { // 1

    private final int x;  // 2
    private final int y;
    private final List<String> names; // Mutable list
    private final Address address; // Mutable object

    public PointImmutableClass(int x, int y, List<String> names, Address address) { // 3\
        this.x = x;
        this.y = y;
        this.names = Collections.unmodifiableList(new ArrayList<>(names)); // Defensive copy
        this.address = new Address(address.getStreet(), address.getCity()); // Deep copy
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    // Return an unmodifiable view of the list to prevent modification
    public List<String> getNames() {
        return names;
    }

    // Create a new Point with a modified list (optional)
    public PointImmutableClass withNewNames(List<String> newNames) {
        return new PointImmutableClass(x, y, new ArrayList<>(newNames), address); // New list instance
    }

    public Address getAddress() {
        return new Address(address.getStreet(), address.getCity()); // Deep copy
    }

    // Create a new Point with a modified address (optional)
    public PointImmutableClass withNewAddress(Address newAddress) {
        return new PointImmutableClass(x, y, names, new Address(newAddress.getStreet(), newAddress.getCity()));
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + names + ", " + address + ")";
    }
}

class Address {
    private final String street;
    private final String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
    // 4.) No setter involved
}

