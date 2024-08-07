package DesignPattern.BehaviouralDesign.IteratorPattern;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class Driver {
    public static void main(String[] args) {
        BookCollection collection = new BookCollection();
        collection.addBook(new Book("Design Patterns", "Gang of Four"));
        collection.addBook(new Book("Clean Code", "Robert C. Martin"));
        collection.addBook(new Book("Java Concurrency in Practice", "Brian Goetz"));

        IIterator<Book> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Book book = iterator.next();
            System.out.println(book);
        }
    }
}
