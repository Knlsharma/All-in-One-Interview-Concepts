package DesignPattern.BehaviouralDesign.ObserverPattern;

/**
 * @author : Kunal Sharma
 * @since : 16/06/24, Sunday
 **/
public class EmailMsgListener implements Listener{

    private final String email;
    public EmailMsgListener(String email) {
        this.email = email;
    }

    @Override
    public void update() {

        System.out.println("Sending mail to " + email);
    }

}
