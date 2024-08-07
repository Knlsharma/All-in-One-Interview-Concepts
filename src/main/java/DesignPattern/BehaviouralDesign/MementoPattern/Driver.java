package DesignPattern.BehaviouralDesign.MementoPattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class Driver {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();
        TextEditorHistory history = new TextEditorHistory();

        // Type some text
        textEditor.write("First line. ");
        System.out.println("Current text: " + textEditor.getText());

        // Save checkpoint
        history.save(textEditor.save());

        // Type more text
        textEditor.write("Second line. ");
        System.out.println("Current text: " + textEditor.getText());

        // Save another checkpoint
        history.save(textEditor.save());

        // Type more text
        textEditor.write("Third line. ");
        System.out.println("Current text: " + textEditor.getText());

        // Undo to previous state
        TextEditorMemento memento = history.undo();
        if (memento != null) {
            textEditor.restore(memento);
            System.out.println("Undo: " + textEditor.getText());
        }

        // Undo again
        memento = history.undo();
        if (memento != null) {
            textEditor.restore(memento);
            System.out.println("Undo: " + textEditor.getText());
        }

    }
}
