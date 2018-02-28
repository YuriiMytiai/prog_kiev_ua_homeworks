package homework2.task4;

/*
Написать класс:
Book (книга).
Свойства: название, автор, издательство, год издания, количество страниц, цена, тип переплета.
 */

public class Book {
    private final String author;
    private final String publishingHouse;
    private final int year;
    private final String name;
    private int numPages;
    private double price;
    private double bookBindingType;

    public Book(String name, String author, int year, String publishingHouse) {
        this.author = author;
        this.name = name;
        this. publishingHouse = publishingHouse;
        this.year = year;
    }




    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getPublishingHouse() {
        return publishingHouse;

    }

    public void setNumPages(int numPages) {
        this.numPages = numPages;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBookBindingType(double bookBindingType) {
        this.bookBindingType = bookBindingType;
    }

    public String toString() {
        return String.format("%s.-%s, %d.\n%s\n", name, author, year, publishingHouse);
    }

}
