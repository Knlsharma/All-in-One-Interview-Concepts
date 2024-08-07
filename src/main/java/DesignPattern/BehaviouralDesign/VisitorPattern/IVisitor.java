package DesignPattern.BehaviouralDesign.VisitorPattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public interface IVisitor {
    void visit(Chair chair);
    void visit(Bed bed);
    void visit(Table table);
}
