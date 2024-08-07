package DesignPattern.BehaviouralDesign.ObserverPattern;

/**
 * @author : Kunal Sharma
 * @since : 16/06/24, Sunday
 **/
public class MobileAppListener implements Listener  {
    private final String username;

    public MobileAppListener(String username) {
        this.username = username;
    }

    @Override
    public void update() {

        System.out.println("Sending mobile app push notification to " + username);
    }
}
