package DesignPattern.BehaviouralDesign.ChainOfResponsibilityPattern;

/**
 * @author : Kunal Sharma
 * @since : 23/04/23, Sunday
 **/
public class RealHandler3 extends IHandler {
    public RealHandler3(IHandler next) {
        super(next);
    }

    void handleRequest(Request obj) {
        if(obj.state < 0) {
            System.out.println("All negatives are handled here");
        } else if(next != null) {
            System.out.println("Not a negative number, hence delegating forward");
            next.handleRequest(obj);
        }
    }
}