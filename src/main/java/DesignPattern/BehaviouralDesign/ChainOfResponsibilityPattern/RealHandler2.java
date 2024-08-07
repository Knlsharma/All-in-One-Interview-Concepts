package DesignPattern.BehaviouralDesign.ChainOfResponsibilityPattern;

/**
 * @author : Kunal Sharma
 * @since : 23/04/23, Sunday
 **/
public class RealHandler2 extends IHandler {
    public RealHandler2(IHandler next) {
        super(next);
    }

    void handleRequest(Request obj) {
        if(obj.state == 0) {
            System.out.println("All 0's are handled here");
        } else if(next != null) {
            System.out.println("Not a 0 number, hence delegating forward");
            next.handleRequest(obj);
        }
    }
}
