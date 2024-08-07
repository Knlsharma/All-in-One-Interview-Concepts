package DesignPattern.BehaviouralDesign.ObserverPattern;

/**
 * @author : Kunal Sharma
 * @since : 16/06/24, Sunday
 **/
public class Store {

    private final NotificationService notificationService;

    public Store() {
        notificationService = new NotificationService();
    }

    public void newItemNotify() {
        notificationService.notifyCustomers();
    }

    public NotificationService getService() {
        return notificationService;
    }

}
