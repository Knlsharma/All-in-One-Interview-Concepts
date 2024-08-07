package DesignPattern.BehaviouralDesign.VisitorPattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class Chair {

    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
