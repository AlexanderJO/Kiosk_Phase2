
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Makes up the user interface (text based) of the application.
 * Responsible for all user interaction, like displaying the menu
 * and receiving input from the user.
 * Hei sondre gut
 * 
 * @author asty
 * @version 1.0
 */
public class ApplicationUI
{

   
    // The menu tha will be displayed. Please edit/alter the menu
    // to fit your application (i.e. replace "prodct" with "litterature"
    // etc.
    private String[] menuItems = {
        "1. List all books",
        "2. Add new book",
        "3. Find a book by name",
    };

    private BookRegistry bookRegistry;

    /**
     * Creates an instance of the ApplicationUI User interface.
     */
    public ApplicationUI() 
    {
        this.bookRegistry = new BookRegistry();
    }

    /**
     * Starts the application by showing the menu and retrieving input from the
     * user.
     */
    public void start()
    {
        this.init();

        boolean quit = false;

        while (!quit) 
        {
            try 
            {
                int menuSelection = this.showMenu();
                switch (menuSelection) 
                {
                    case 1:
                        this.listAllBooks();
                        break;

                    case 2:
                        this.addNewBook();
                        break;

                    case 3:
                        this.findProductByName();
                        break;

                    case 4:
                        System.out.println("\nThank you for using Application v0.1. Bye!\n");
                        quit = true;
                        break;

                    default:
                }
            } 
            catch (InputMismatchException ime) 
            {
                System.out.println("\nERROR: Please provide a number between 1 and " + this.menuItems.length + "..\n");
            }
        }        
        
    }

    /**
     * Displays the menu to the user, and waits for the users input. The user is
     * expected to input an integer between 1 and the max number of menu items. 
     * If the user inputs anything else, an InputMismatchException is thrown. 
     * The method returns the valid input from the user.
     *
     * @return the menu number (between 1 and max menu item number) provided by the user.
     * @throws InputMismatchException if user enters an invalid number/menu choice
     */
    private int showMenu() throws InputMismatchException 
    {
        System.out.println("\n**** Application v0.1 ****\n");
        // Display the menu
        for ( String menuItem : menuItems )
        {
            System.out.println(menuItem);
        }
        int maxMenuItemNumber = menuItems.length + 1;
        // Add the "Exit"-choice to the menu
        System.out.println(maxMenuItemNumber + ". Exit\n");
        System.out.println("Please choose menu item (1-" + maxMenuItemNumber + "): ");
        // Read input from user
        Scanner reader = new Scanner(System.in);
        int menuSelection = reader.nextInt();
        if ((menuSelection < 1) || (menuSelection > maxMenuItemNumber)) 
        {
            throw new InputMismatchException();
        }
        return menuSelection;
    }

    /**
     * Reads the input from the user.
     */

    // ------ The methods below this line are "helper"-methods, used from the menu ----
    // ------ All these methods are made privat, since they are only used by the menu ---
    
    /**
     * Initializes the application.
     * Typically you would create the LiteratureRegistrer-instance here
     */
    private void init()
    {
        System.out.println("init() was called");
    }

    /**
     * Lists all the products/literature in the register
     */
    private void listAllBooks()
    {
        Iterator<Book> bookListIt = this.bookRegistry.getIterator();

        while ( bookListIt.hasNext() )
        {
            Book book = bookListIt.next();
            System.out.println("Title: " + book.getTitle() + ", Publisher: " + book.getDatePublished());
        }
    }

    
    /**
     * Add a new product/literature to the register.
     * In this method you have to add code to ask the
     * user for the necessary information you need to 
     * create an instance of the product, which you
     * then send as a parameter to the addNewspaper()-
     * method of the register.
     * Remember to also handle invalid input from the
     * user!!
     */
    private void addNewBook()
    {
        // Brukeren har nå valgt å legge til en bok
        System.out.println("Please enter the title of the book: ");
        Scanner readerTitle = new Scanner(System.in);                // Creates a scanner that waits for user input.
        String title = readerTitle.nextLine();                       // Waits for the user to push enter.

        System.out.println("Please enter the publisher of the book: ");
        Scanner readerPublisher = new Scanner(System.in);                // Creates a scanner that waits for user input.
        String publisher = readerPublisher.nextLine();                       // Waits for the user to push enter.

        System.out.println("Please enter the author of the book: ");
        Scanner readerAuthor = new Scanner(System.in);                // Creates a scanner that waits for user input.
        String author = readerAuthor.nextLine();                      // Waits for the user to push enter.

        System.out.println("Please enter the edition of the book: ");
        Scanner readerEdition = new Scanner(System.in);                // Creates a scanner that waits for user input.
        String edition = readerEdition.nextLine();                     // Waits for the user to push enter.

        System.out.println("Please enter the publishing date of the book: ");
        Scanner readerDatePublished = new Scanner(System.in);                // Creates a scanner that waits for user input.
        String datePublished = readerDatePublished.nextLine();                     // Waits for the user to push enter.

        // Legg inn boka i registeret
        this.bookRegistry.addBook(title, publisher, author, edition, datePublished);
    }

    /**
     * Find and display a product based om name (title).
     * As with the addNewProduct()-method, you have to
     * ask the user for the string (name/title/publisher)
     * to search for, and then use this string as input-
     * parameter to the method in the register-object.
     * Then, upon return from the register, you need
     * to print the details of the found item.
     */
    private void findProductByName()
    {
        System.out.println("findProductByName() was called");
    }
    
}
