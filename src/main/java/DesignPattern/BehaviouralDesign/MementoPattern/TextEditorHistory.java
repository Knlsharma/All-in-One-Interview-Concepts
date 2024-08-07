package DesignPattern.BehaviouralDesign.MementoPattern;

import java.util.Stack;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class TextEditorHistory {
    private Stack<TextEditorMemento> history = new Stack<>();

    public void save(TextEditorMemento memento) {
        history.push(memento);
    }

    public TextEditorMemento undo() {
        if (!history.isEmpty()) {
            return history.pop();
        }
        return null;
    }
}
