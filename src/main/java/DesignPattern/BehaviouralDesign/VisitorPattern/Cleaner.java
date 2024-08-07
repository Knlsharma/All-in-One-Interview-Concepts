package DesignPattern.BehaviouralDesign.VisitorPattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class Cleaner implements IVisitor {
    @Override
    public void visit(Chair chair) {
        System.out.println("Cleaning chair to remove dust and stains.");
    }

    @Override
    public void visit(Bed bed) {
        System.out.println("Changing bed sheets and tidying up the bed.");
    }

    @Override
    public void visit(Table table) {
        System.out.println("Wiping and polishing table surface.");
    }
}

