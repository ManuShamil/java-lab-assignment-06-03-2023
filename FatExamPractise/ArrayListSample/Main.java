package ArrayListSample;

import java.util.ArrayList;

class Book {
    String bookName;
    public Book( String bookName ) {
        this.bookName = bookName;
    }
}

class Library {
    ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook( Book newBook ) {
        this.books.add(newBook);
    }

    //! delete
    public void deleteBook( Book bookToDelete ) {
        this.books.remove(bookToDelete);
    }

    //! search by member variable
    public void searchBookByName( String bookName ) {
        for ( Book book : this.books )
            if ( book.bookName == "bookName" ) {
                System.out.println("Found book: " + bookName);
            }
    }

    //! search by member variable and update member variable
    public void updateBookName( String oldBookName, String newBookName ) {
        for ( Book book : this.books )
            if ( book.bookName == oldBookName )
                book.bookName = newBookName;
    }
}

public class Main {
    public static void main(String[] args) {
        Library myLibrary = new Library();
        myLibrary.addBook(new Book("Harry Potter"));
        myLibrary.searchBookByName("Harry Potter");
    }
}
