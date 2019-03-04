import java.util.Iterator;
import java.util.ArrayList;

/**
 * Represents a book registry, holding a collection of books. This book registry will be included in
 * a literature collection, either published, periodical or non-periodical.
 * 
 * The object Book contains the parameters Title, Author, Publisher, Date published, Edition and Series.
 * 
 * And for the time being, BlueJ is used as the User Interface for Phase 1.
 * For Phase 1, only class Book will be implemented.
 * 
 * In this registry you can;
 * <p>
 *  <ul>
 *  <li>    Add book with title, publisher, author, edition and publish date   </li>
 *  <li>    Add book with title, publisher, author, edition, publish date and series </li>
 *  <li>    Add book to series </li>
 *  <li>    Remove book    </li>
 *  <li>    List and get all books    </li>
 *  <li>    List and get all books by title </li>
 *  <li>    List and get all books by author </li>
 *  <li>    List and get all books by publisher </li>
 *  <li>    List and get all books in series </li>
 *  </ul>
 *  <p>
 *  <b> Important note: fillBookListWithDummies to be made private when released to customer.
 *                      Method used for debugging purposes.</b>
 *  
 *  @author     Alexander J. Overvåg, Sondre Nerhus, Gustav S. Hagen
 *  @version    v1.0 (beta) 2019.02.13
 */
public class BookRegistry
{
    // Instance variable for the class Registry.
    private ArrayList<Book> bookList;           // ArrayList collection of books.

    /**
     * Constructor for object of class Registry.
     * Makes the list for the Registry.
     */
    public BookRegistry()
    {
        // Initialises the instance variables for class Book.
        this.bookList = new ArrayList<Book>();

    }

    /**
     * Create book to the bookList.
     * 
     * @param title         Title of the book.
     * @param publisher     Publisher of the book.
     * @param author        Author of the book.
     * @param edition       Edition of the book (Ex. Sixth Edition or 6th. Edition)
     * @param datePublished Publish date of the book.
     */    
    public void addBook(String title, String publisher, String author,
    String edition, String datePublished)
    {
        this.bookList.add(new Book(title, publisher, author, edition, datePublished) );
    }

    /**
     * Create book with series to the bookList.
     * 
     * @param title         Title of the book.
     * @param publisher     Publisher of the book.
     * @param author        Author of the book.
     * @param edition       Edition of the book (Ex. Sixth Edition or 6th. Edition)
     * @param datePublished Publish date of the book.
     * @param series        Series of the book.
     */
    public void addBookWithSeries(String title, String publisher, String author, 
    String edition, String datePublished, String series)
    {
        this.bookList.add(new Book(title, publisher, author, edition, datePublished, series) );
    }

    /**
     * Removes the book by using the title.
     * 
     * @param title     Title of the book to be removed.
     */
    public void removeBook(String title)
    {
        boolean found = false;
        int index = 0;

        while ( ( index < this.bookList.size() ) && !found )
        {
            Book book = this.bookList.get(index);

            if ( book.getTitle().equals(title) )
            {
                this.bookList.remove(book);
                found = true;
            }
            index++;
        }
    }

    /**
     * Adds a book to a series.
     * 
     * @param title     Title of the book to be added.
     * @param series    Series of the book to be added.
     */
    public void addBookToSeries(String title, String series)
    {
        boolean found = false;
        int index = 0;
        while ( ( index < this.bookList.size() ) && !found )
        {
            Book book = this.bookList.get(index);

            if ( book.getTitle().equals(title) )
            {
                book.setBookInSeries(series);
                found = true;
            }
            index++;
        }
    }

    /**
     * Lists book by title. Title is assumed to be unique.
     * 
     * @param title Title of the book.
     */
    public void listBookByTitle(String title)
    {
        boolean found = false;
        int index = 0;

        System.out.println("### Start of list ###");

        while ( ( index < this.bookList.size() ) && !found )
        {
            Book book = this.bookList.get(index);

            if ( book.getTitle().equals(title) )
            {
                if ( book.getSeries() == null )
                {
                    printBook(book);
                }

                else
                {
                    printBookWithSeries(book);
                }
                found = true;
            }

            index++;
        }

        System.out.println("### End of list ###");
    }

    /**
     * Return book by title. Title is assumed to be unique.
     * 
     * @param title Title of the book.
     * @return Return book by title.
     */
    public Book getBookByTitle(String title)
    {
        Book book = null;

        boolean found = false;
        int index = 0;

        while ( index < this.bookList.size() && !found )
        {
            if ( this.bookList.get(index).getTitle().equals(title) )
            {

                book = this.bookList.get(index);

                found = true;
            }

            index++;
        }

        return book;
    }

    /**
     * Lists all books by author.
     * 
     * @param author Author of the book.
     */
    public void listBooksByAuthor(String author)
    {
        System.out.println("### Start of list ###");

        for ( Book book : this.bookList )
        {
            if ( book.getAuthor().equals(author) )
            {
                if ( book.getSeries() == null )
                {
                    printBook(book);
                }

                else
                {
                    printBookWithSeries(book);
                }
            }
        }

        System.out.println("### End of list ###");
    }

    /**
     * Return all books by author.
     * 
     * @param author Author of the book.
     * @return Return all books by author.
     */
    public ArrayList<Book> getBooksByAuthor(String author)
    {
        ArrayList<Book> bookList = new ArrayList();

        for ( Book book : this.bookList )
        {
            if ( book.getAuthor().equals(author) )
            {
                bookList.add(book);
            }
        }

        return bookList;
    }

    /**
     * Lists all books by publisher.
     * 
     * @param publisher Publisher of the book.
     */
    public void listBooksByPublisher(String publisher)
    {
        System.out.println("### Start of list ###");

        for ( Book book : this.bookList )
        {
            if ( book.getPublisher().equals(publisher) )
            {
                if ( book.getSeries() == null )
                {
                    printBook(book);
                }

                else
                {
                    printBookWithSeries(book);
                }
            }
        }

        System.out.println("### End of list ###");
    }

    /**
     * Lists all books by publisher.
     * 
     * @param publisher Publisher of the book.
     * @return Returns the publisher of the book.
     */
    public ArrayList<Book> getBooksByPublisher(String publisher)
    {
        ArrayList<Book> bookList = new ArrayList();

        for ( Book book : this.bookList )
        {
            if ( book.getPublisher().equals(publisher) )
            {
                bookList.add(book);
            }
        }

        return bookList;
    }

    /**
     * Lists all books in the collection.
     */
    public void listAllBooks()
    {
        System.out.println("### Start of list ###");

        for ( Book book : this.bookList )
        {
            if ( book.getSeries() == null )
            {
                printBook(book);
            }

            else
            {
                printBookWithSeries(book);
            }
        }

        System.out.println("### End of list ###");
    }

    /**
     * Lists all books in the collection.
     */
    public ArrayList<Book> getAllBooks()
    {
        return this.bookList;
    }
    
    /**
     * Lists all books in the collection.
     */
    // public Iterator<Book> getAllIteratedBooks()
    {
        
        // return this.bookList;
    }

    /**
     * List book without series.
     * 
     * @param book Takes in the object Book.
     */
    private void printBook(Book book)
    {
        System.out.println("Title: " + book.getTitle() + ", " + "Publisher: " + book.getPublisher() +
            ", " + "Author: " + book.getAuthor() + ", " + "Edition: " + book.getEdition() + ", " +
            "Published date: " + book.getDatePublished() );
    }

    /**
     * List book with series.
     * 
     * @param book Takes in the object Book.
     */
    private void printBookWithSeries(Book book)
    {
        System.out.println("Title: " + book.getTitle() + ", " + "Publisher: " + book.getPublisher() +
            ", " + "Author: " + book.getAuthor() + ", " + "Edition: " + book.getEdition() + ", " +
            "Published date: " + book.getDatePublished() + ", " + "Book series: " + book.getSeries() );
    }

    public void fillBookListWithDummies()
    {
        this.bookList.add(new Book("Book 1", "Publisher 1", "Author 1", "First Edition", "2019.01.01", "Naked gun"));
        this.bookList.add(new Book("Book 2", "Publisher 1", "Author 1", "Second Edition", "2019.01.02", "Naked gun"));
        this.bookList.add(new Book("Book 3", "Publisher 2", "Author 1", "First Edition", "2019.01.01", "Sexy gun"));
        this.bookList.add(new Book("Book 4", "Publisher 3", "Author 2", "First Edition", "2019.01.01", "Naked gun"));
        this.bookList.add(new Book("Book 5", "Publisher 1", "Author 2", "First Edition", "2019.01.01", "Dressed gun"));

        this.bookList.add(new Book("Book 6", "Publisher 1", "Author 1", "First Edition", "2019.01.01"));
        this.bookList.add(new Book("Book 7", "Publisher 1", "Author 5", "Second Edition", "2019.01.02"));
        this.bookList.add(new Book("Book 8", "Publisher 2", "Author 1", "First Edition", "2019.01.05"));
        this.bookList.add(new Book("Book 9", "Publisher 3", "Author 2", "Third Edition", "2019.01.05"));
        this.bookList.add(new Book("Book 10", "Publisher 1", "Author 2", "First Edition", "2019.01.06"));
    }

}