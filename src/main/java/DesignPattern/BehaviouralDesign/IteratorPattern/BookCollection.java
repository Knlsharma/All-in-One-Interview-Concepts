package DesignPattern.BehaviouralDesign.IteratorPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class BookCollection implements IIterableCollection<Book> {
    private List<Book> books;

    public BookCollection() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public IIterator<Book> iterator() {
        return new BookIterator(books);
    }
}
