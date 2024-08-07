package DesignPattern.BehaviouralDesign.IteratorPattern;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author : Kunal Sharma
 * @since : 16/07/24, Tuesday
 **/
public class BookIterator implements IIterator<Book> {
    private List<Book> books;
    private int position;

    public BookIterator(List<Book> books) {
        this.books = books;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < books.size();
    }

    @Override
    public Book next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements");
        }
        Book book = books.get(position);
        position++;
        return book;
    }
}