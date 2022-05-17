package ch.bzz.bookshelf.model;

import ch.bzz.bookshelf.data.DataHandler;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

public class Book {
    private String bookUUID;
    private String title;
    private String author;
    private String isbn;

    @JsonIgnore
    private Publisher publisher;
    private BigDecimal price;

    public String getBookUUID() {
        return bookUUID;
    }

    public void setBookUUID(String bookUUID) {
        this.bookUUID = bookUUID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * gets the publisherUUID from the Publisher-object
     * @return
     */
    public String getPublisherUUID() {
        return getPublisher().getPublisherUUID();
    }

    /**
     * creates a Publisher-object without the booklist
     * @param publisherUUID
     */
    public void setPublisherUUID(String publisherUUID) {
        setPublisher( new Publisher());
        Publisher publisher = DataHandler.getInstance().readPublisherByUUID(publisherUUID);
        getPublisher().setPublisherUUID(publisherUUID);
        getPublisher().setPublisher(publisher.getPublisher());

    }
}
