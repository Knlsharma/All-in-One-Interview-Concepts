package DesignPattern.BehaviouralDesign.ObserverPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Kunal Sharma
 * @since : 16/06/24, Sunday
 **/
public class NotificationService {

    private final List<Listener> customers;

    public NotificationService() {
        customers = new ArrayList<>();
    }

    public void subscribe(Listener listener) {
        customers.add(listener);
    }

    public void unsubscribe(Listener listener) {
        customers.remove(listener);
    }

    public void notifyCustomers() {
        for (Listener listener : customers) {
            listener.update();
        }
    }
}
