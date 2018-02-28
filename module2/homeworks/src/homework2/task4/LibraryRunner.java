package homework2.task4;

/*
Написать класс:
Клиентский класс LibraryRunner: протестировать функционал предыдущих классов.
 */

public class LibraryRunner {
    public static void main(String[] args) {
        Book book1 = new Book("Voina i mir. Tom 1", "Tolstoi", 1867,"123");
        Book book2 = new Book("Ilida", "Homer", -800,"");
        Book book3 = new Book("Voina i mir. Tom 2", "Tolstoi", 1867,"45678");
        Book book4 = new Book("Voina i mir. Tom 3", "Tolstoi", 1867,"123");
        Book book5 = new Book("1Q84", "Murakami", 2010,"789");

        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);

        System.out.println("All books by Tolstoi: \n" + library.findByAuthor("Tolstoi"));
        System.out.println("All books from 123 publishing house: \n" + library.findByPublishingHouse( "123"));
        System.out.println("All books after 2010: \n" + library.findByYearsAfterThis(2010));


    }
}
