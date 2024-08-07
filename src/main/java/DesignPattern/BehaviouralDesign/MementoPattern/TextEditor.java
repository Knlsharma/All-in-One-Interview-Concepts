package DesignPattern.BehaviouralDesign.MementoPattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class TextEditor {
    private StringBuilder text = new StringBuilder();

    public void write(String newText) {
        text.append(newText);
    }

    public String getText() {
        return text.toString();
    }

    public TextEditorMemento save() {
        return new TextEditorMemento(text.toString());
    }

    public void restore(TextEditorMemento memento) {
        text = new StringBuilder(memento.getText());
    }
}
