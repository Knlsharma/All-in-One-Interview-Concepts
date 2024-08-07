package DesignPattern.BehaviouralDesign.VisitorPattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class Inspector implements IVisitor {
    @Override
    public void visit(Chair chair) {
        System.out.println("Inspecting chair for defects.");
    }

    @Override
    public void visit(Bed bed) {
        System.out.println("Inspecting bed for stability and cleanliness.");
    }

    @Override
    public void visit(Table table) {
        System.out.println("Inspecting table for scratches and marks.");
    }
}