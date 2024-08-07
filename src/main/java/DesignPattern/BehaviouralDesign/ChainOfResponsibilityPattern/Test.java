package DesignPattern.BehaviouralDesign.ChainOfResponsibilityPattern;

/**
 * @author : Kunal Sharma
 * @since : 23/04/23, Sunday
 **/
public class Test {

    public static void main(String[] args) {
//        Handler o3 = new RealHandler3(null);
//        Handler o2 = new RealHandler2(o3);
//        Handler o1 = new RealHandler1(o2);

        // or same as above
        IHandler o1 = new RealHandler1(
                new RealHandler2(
                        new RealHandler3(null)));


        Request req = new Request();
        req.state = 10;

        o1.handleRequest(req);
    }
}
