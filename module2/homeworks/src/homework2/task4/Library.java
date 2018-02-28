package homework2.task4;

/*
Написать класс:
Library (библиотека).
Свойства: список книг.
Методы:
поиск книг заданного автора
поиск книг, выпущенных заданным издательством
поиск книг, выпущенных после заданного года
 */

import java.util.ArrayList;

public class Library {

    private final ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) { books.add(book);}

    public ArrayList<Book> findByAuthor(String author) {
        ArrayList<Book> booksList = new ArrayList<>();
        for (Book curBook:books) {
            if (curBook.getAuthor().equals(author)) {
                booksList.add(curBook);
            }
        }

        return booksList;
    }

    public ArrayList<Book> findByPublishingHouse(String ph) {
        ArrayList<Book> booksList = new ArrayList<>();
        for (Book curBook:books) {
            if (curBook.getPublishingHouse().equals(ph)) {
                booksList.add(curBook);
            }
        }

        return booksList;
    }

    public ArrayList<Book> findByYearsAfterThis(int targetYear) {
        ArrayList<Book> booksList = new ArrayList<>();
        for (Book curBook:books) {
            if (curBook.getYear() >= targetYear) {
                booksList.add(curBook);
            }
        }

        return booksList;
    }

}
